using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;
using BusinessLogic.Controllers;
using BusinessLogic.Model.Providers;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using FakeItEasy;
using GrpcFileGeneration.Models;
using Microsoft.AspNetCore.Mvc;
using RiskFirst.Hateoas;
using Xunit;

namespace ApiTest
{
    public class ProviderControllerTest
    {
        [Fact]
        public async void GetAllApprovedProviders()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.GetAllProvidersAsync(1))
                .Returns(
                    Task.FromResult(new Page<ProviderList>()
                    {
                        Content = new ProviderList()
                        {
                            Providers = new List<Provider>()
                            {
                                new Provider(),
                                new Provider(),
                                new Provider(),
                                new Provider(),
                                new Provider()
                            },
                        }
                    }));
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.GetProvidersAsync(true, "", 1);

            //Assert
            var list = (Page<ProviderList>) ((ObjectResult) result.Result).Value;
            Assert.Equal(5, list.Content.Providers.Count);
        }

        [Fact]
        public async void GetAllProvidersByName()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.GetAllProvidersByNameAsync(A<string>.Ignored, A<int>.Ignored))
                .Returns(
                    Task.FromResult(new Page<ProviderList>()
                    {
                        Content = new ProviderList()
                        {
                            Providers = new List<Provider>()
                            {
                                new Provider()
                                {
                                    CompanyName = "Hatomas"
                                },
                                new Provider()
                                {
                                    CompanyName = "Tomasito"
                                },
                                new Provider()
                                {
                                    CompanyName = "Tomas"
                                },
                                new Provider()
                                {
                                    CompanyName = "Patomas"
                                },
                                new Provider()
                                {
                                    CompanyName = "Latomas"
                                }
                            },
                        }
                    }));
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.GetProvidersAsync(true, "Tomas", 1);

            //Assert
            var list = (Page<ProviderList>) ((ObjectResult) result.Result).Value;
            Assert.Equal(5, list.Content.Providers.Count);
        }

        [Fact]
        public async void GetAllNotApprovedProvidersAsync()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.GetAllNotApprovedProvidersAsync(A<int>.Ignored))
                .Returns(
                    Task.FromResult(new Page<ProviderList>()
                    {
                        Content = new ProviderList()
                        {
                            Providers = new List<Provider>()
                            {
                                new Provider()
                                {
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    IsApproved = false
                                }
                            },
                        }
                    }));
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.GetProvidersAsync(false, "", 0);

            //Assert
            var list = (Page<ProviderList>) ((ObjectResult) result.Result).Value;
            Assert.Equal(5, list.Content.Providers.Count);
        }


        [Fact]
        public async void GetAllNotApprovedProvidersByNameAsync()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.GetAllProvidersByNameAsync(A<string>.Ignored, A<int>.Ignored))
                .Returns(
                    Task.FromResult(new Page<ProviderList>
                    {
                        Content = new ProviderList
                        {
                            Providers = new List<Provider>
                            {
                                new Provider()
                                {
                                    CompanyName = "Tomas",
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    CompanyName = "Tomasko",
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    CompanyName = "Tomasito",
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    CompanyName = "Latomas",
                                    IsApproved = false
                                },
                                new Provider()
                                {
                                    CompanyName = "Halatomas",
                                    IsApproved = false
                                }
                            },
                        }
                    }));
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.GetProvidersAsync(false, "Tomas", 0);

            //Assert
            var list = (Page<ProviderList>) ((ObjectResult) result.Result).Value;
            Assert.Equal(5, list.Content.Providers.Count);
        }

        [Fact]
        public async void GetProviderById()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.GetProviderByIdAsync(A<int>.Ignored))
                .Returns(Task.FromResult(new Provider()));
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.GetProviderById(1);
            var response = ((ObjectResult) result.Result);
            var provider = (Provider) response.Value;
            var statusCode = response.StatusCode;

            //Assert
            Assert.NotNull(provider);
            Assert.Equal(200, statusCode);
        }

        [Fact]
        public async void DeleteProviderAsync()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.DeleteProviderAsync(A<int>.Ignored))
                .Returns(Task.CompletedTask);
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.DeleteProviderAsync(1);

            //Assert
            var response = (StatusCodeResult) result;
            var responseStatusCode = response.StatusCode;
            Assert.Equal(200, responseStatusCode);
        }

        [Fact]
        public async void DeleteProviderAsyncProviderDoesNotExist()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.DeleteProviderAsync(A<int>.Ignored))
                .Throws<Exception>();
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.DeleteProviderAsync(1);

            //Assert
            var response = (StatusCodeResult) result;
            var responseStatusCode = response.StatusCode;
            Assert.Equal(403, responseStatusCode);
        }

        [Fact]
        public async void GetProviderByIdNotFound()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.GetProviderByIdAsync(A<int>.Ignored))
                .Throws(new Exception("error"));
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            //Act
            var result = await controller.GetProviderById(1);
            var response = (ObjectResult) result.Result;
            var responseValue = (string) response.Value;
            var statusCode = response.StatusCode;

            //Assert
            Assert.NotNull(responseValue);
            Assert.Equal(403, statusCode);
        }

        [Fact]
        public async void EditProvider()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.EditProviderAsync(A<Provider>.Ignored))
                .ReturnsLazily((Provider p) => p);
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            var provider = new Provider()
            {
                CompanyName = "New Company",
                IsApproved = true
            };

            //Act
            var result = await controller.EditProvider(provider);
            var response = (ObjectResult) result.Result;
            var responseValue = (Provider) response.Value;
            var statusCode = response.StatusCode;

            //Assert
            Assert.NotNull(responseValue);
            Assert.Equal(200, statusCode);
        }

        [Fact]
        public async void EditProviderHandlingException()
        {
            //Arrange
            var fakeModel = A.Fake<IProviderModel>();
            A
                .CallTo(() => fakeModel.EditProviderAsync(A<Provider>.Ignored))
                .Throws<Exception>();
            var fakeLinksService = A.Fake<ILinksService>();
            var controller = new ProviderController(fakeLinksService, fakeModel);

            var provider = new Provider()
            {
                CompanyName = "New Company",
                IsApproved = true
            };

            //Act
            var result = await controller.EditProvider(provider);
            var response = (ObjectResult) result.Result;
            var responseValue = (string) response.Value;
            var statusCode = response.StatusCode;

            //Assert
            Assert.NotNull(responseValue);
            Assert.Equal(403, statusCode);
        }
    }
}