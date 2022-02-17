using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using BusinessLogic.Networking.Providers;
using GrpcFileGeneration.Models;
using GrpcFileGeneration.Services;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Model.Providers
{
    public class ProviderModel : IProviderModel
    {
        IProviderNet network;
        private IValidator validator;
        
        public ProviderModel(IProviderNet network, IValidator validator)
        {
            this.network = network;
            this.validator = validator;
        }

        public Task<User> CreateProviderAsync(Provider provider)
        {
            return network.CreateProviderAsync(provider);
        }

        public Task<Page<ProviderList>> GetAllProvidersAsync(int page)
        {
            return network.GetAllProvidersAsync(page);
        }

        public Task<Provider> GetProviderByIdAsync(int id)
        {
            return network.GetProviderByIdAsync(id);
        }

        public Task<Provider> EditProviderAsync(Provider provider)
        {
            return network.EditProviderAsync(provider);
        }

        public Task DeleteProviderAsync(int id)
        {
            return network.DeleteProvider(id);
        }

        public Task<Page<ProviderList>> GetAllNotApprovedProvidersAsync(int page)
        {
            return network.GetAllNotApprovedProvidersAsync(page);
        }

        public Task<Page<ProviderList>> GetAllProvidersByNameAsync(string name, int page)
        {
            return network.GetAllProvidersByNameAsync(name, page);
        }
    }
}