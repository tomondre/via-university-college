using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using System.Xml.Xsl;
using BusinessLogic.Controllers;
using BusinessLogic.Model.Experiences;
using BusinessLogic.Model.Orders;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using BusinessLogic.Networking.Experiences;
using BusinessLogic.Networking.Orders;
using FakeItEasy;
using GrpcFileGeneration.Models;
using GrpcFileGeneration.Models.Orders;
using Microsoft.Extensions.Caching.Memory;
using RiskFirst.Hateoas;
using WebShop.Cache;
using Xunit;

namespace ApiTest
{
    public class OrderControllerTest
    {
        private OrderModel orderModel;

        public OrderControllerTest()
        {
        }

        [Fact]
        public async void CreateOrder()
        {
            //Arrange
            var orderIdWhenCreated = 1;
            var fakeOrder = FakeOrderNet(orderIdWhenCreated);
            var fakeExperienceModel = FakeExperienceModel(true);
            var fakeCacheService = FakeCacheService();
            var order = DummyOrder();

            orderModel = new OrderModel(fakeOrder, fakeExperienceModel, fakeCacheService);

            //Act
            var orderAsync = await orderModel.CreateOrderAsync(order);

            //Assert
            Assert.Equal(1, orderAsync.Id);
        }

        [Fact]
        public async void CreateOrderItemNotInStock()
        {
            //Arrange
            var orderIdWhenCreated = 1;
            var fakeOrder = FakeOrderNet(orderIdWhenCreated);
            var fakeExperienceModel = FakeExperienceModel(false);
            var fakeCacheService = FakeCacheService();

            orderModel = new OrderModel(fakeOrder, fakeExperienceModel, fakeCacheService);
            var order = DummyOrder();

            //Act
            Func<Task<Order>> action = () => orderModel.CreateOrderAsync(order);

            //Assert
            await Assert.ThrowsAsync<Exception>(action);
        }

        [Fact]
        public async void GenerateVoucher()
        {
            //Arrange
            var invoke =  (Task<string>) InvokePrivateMethod("GenerateVoucher", new object[]
            {
                new List<Voucher>
                {
                    new Voucher
                    {
                        Img = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
                        Validity = "6",
                        ExperienceName = "Travel"
                    },
                    new Voucher()
                    {
                        Img = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
                        Validity = "6",
                        ExperienceName = "Scuba diving"
                    },
                    new Voucher()
                    {
                        Img = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg",
                        Validity = "6",
                        ExperienceName = "Shooting range"
                    }
                }
            });

            //Assert
            var resultString = await invoke;
            Assert.NotEqual("", resultString);
        }

        
        [Fact]
        public async void CreatePayment()
        {
            //Arrange
            var dummyOrder = DummyOrder();
            
            //Act            
            Func<Task> func = () => (Task) InvokePrivateMethod("CreatePayment", new object[]
            {
                dummyOrder
            });

            //Assert
            await Assert.ThrowsAsync<Exception>(func);
        }
        
        private object InvokePrivateMethod(string methodName, object[] paramters)
        {
            var orderIdWhenCreated = 1;
            var fakeOrder = FakeOrderNet(orderIdWhenCreated);
            var fakeExperienceModel = FakeExperienceModel(true);
            var fakeCacheService = FakeCacheService();
            Type type = typeof(OrderModel);
            var instance = Activator.CreateInstance(type, fakeOrder, fakeExperienceModel, fakeCacheService);
            var methodInfo = type.GetMethods(BindingFlags.NonPublic | BindingFlags.Instance)
                .Where(x => x.Name == methodName && x.IsPrivate)
                .First();
            return methodInfo.Invoke(instance, paramters);
        }
        
        private Order DummyOrder()
        {
            return new Order()
            {
                ShoppingCart = new ShoppingCart()
                {
                    ShoppingCartItems = new List<ExperienceCartItem>()
                    {
                        new ExperienceCartItem()
                        {
                            Experience = new Experience()
                            {
                                Id = 1,
                                Description = "Experience One",
                                Name = "Jumping",
                            },
                            Quantity = 2
                        },
                        new ExperienceCartItem()
                        {
                            Experience = new Experience()
                            {
                                Id = 1,
                                Description = "Experience One",
                                Name = "Jumping",
                            },
                            Quantity = 2
                        }
                    }
                },
                Comment = "Halabala",
                Customer = new Customer()
                {
                    Id = 0
                },
            };
        }

        private IOrderNet FakeOrderNet(int idOfOrderWhenCreated)
        {
            var fakeOrderNet = A.Fake<IOrderNet>();
            A
                .CallTo(() => fakeOrderNet.CreateOrderAsync(A<Order>.Ignored))
                .Returns(Task.FromResult(new Order
                {
                    Id = idOfOrderWhenCreated
                }));
            return fakeOrderNet;
        }

        private IExperienceModel FakeExperienceModel(bool shouldInStockReturn)
        {
            var fakeExperienceModel = A.Fake<IExperienceModel>();
            A
                .CallTo(() => fakeExperienceModel.IsInStockAsync(A<int>.Ignored, A<int>.Ignored))
                .Returns(Task.FromResult(shouldInStockReturn));
            A
                .CallTo(() => fakeExperienceModel.RemoveStockAsync(A<int>.Ignored, A<int>.Ignored))
                .Returns(Task.CompletedTask);
            return fakeExperienceModel;
        }

        private IMemoryCache FakeCacheService()
        {
            var fakeCacheService = A.Fake<IMemoryCache>();
            A
                .CallTo(() => fakeCacheService.Remove(A<string>.Ignored))
                .DoesNothing();
            return fakeCacheService;
        }
    }
}