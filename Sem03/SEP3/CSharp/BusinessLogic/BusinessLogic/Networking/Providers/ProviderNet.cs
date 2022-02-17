using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using GrpcFileGeneration.Models;
using Networking.Provider;
using Networking.Request;
using Networking.User;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Networking.Providers
{
    public class ProviderNet : IProviderNet
    {
        private ProviderService.ProviderServiceClient client;

        public ProviderNet(ProviderService.ProviderServiceClient client)
        {
            this.client = client;
        }

        public async Task<User> CreateProviderAsync(Provider provider)
        {
            var providerMessage = new ProviderMessage(provider.ToMessage());
            var message = await client.CreateProviderAsync(providerMessage);
            var user = new User(message);
            return user;
        }

        public async Task<Page<ProviderList>> GetAllProvidersAsync(int page)
        {
            var pageRequestMessage = new PageRequestMessage()
            {
                PageNumber = page,
                PageSize = 5
            };
            var providersMessage = await client.GetAllProvidersAsync(pageRequestMessage);
            var providers = providersMessage.Providers;

            var providersList = new ProviderList()
            {
                Providers = providers.Select(a => new Provider(a)).ToList()
            };

            var pageContent = new Page<ProviderList>(providersMessage.PageInfo)
            {
                Content = providersList
            };
            return pageContent;
        }

        public async Task<Provider> GetProviderByIdAsync(int id)
        {
            var requestMessage = new RequestMessage()
            {
                Id = id
            };
            var providerById = await client.GetProviderByIdAsync(requestMessage);
            var provider = new Provider(providerById);
            return provider;
        }

        public async Task<Provider> EditProviderAsync(Provider provider)
        {
            var providerMessage = provider.ToMessage();
            var editProvider = await client.EditProviderAsync(providerMessage);
            var editedProvider = new Provider(editProvider);
            return editedProvider;
        }

        public async Task DeleteProvider(int id)
        {
            var requestMessage = new RequestMessage() {Id = id};
            await client.RemoveProviderAsync(requestMessage);
        }

        public async Task<Page<ProviderList>> GetAllNotApprovedProvidersAsync(int page)
        {
            var pageRequestMessage = new PageRequestMessage()
            {
                PageNumber = page,
                PageSize = 5
            };
            
            var allNotApprovedProviders = await client.GetAllNotApprovedProvidersAsync(pageRequestMessage);
            var providerMessages = allNotApprovedProviders.Providers;
            
            var providers = new ProviderList()
            {
                Providers = providerMessages.Select(a => new Provider(a)).ToList()
            };

            var pageContent = new Page<ProviderList>(allNotApprovedProviders.PageInfo)
            {
                Content = providers
            };
            return pageContent;
        }

        public async Task<Page<ProviderList>> GetAllProvidersByNameAsync(string name, int page)
        {
            var requestMessage = new RequestMessage()
            {
                Name = name,
                PageInfo = new PageRequestMessage()
                {
                    PageNumber = page,
                    PageSize = 5
                }
            };
            var allByNameAsync = await client.GetAllByNameAsync(requestMessage);
            var providerMessages = allByNameAsync.Providers;
            var providers = new ProviderList()
            {
                Providers = providerMessages.Select(a => new Provider(a)).ToList()
            };

            var pageContent = new Page<ProviderList>(allByNameAsync.PageInfo)
            {
                Content = providers
            };
            return pageContent;
        }
    }
}