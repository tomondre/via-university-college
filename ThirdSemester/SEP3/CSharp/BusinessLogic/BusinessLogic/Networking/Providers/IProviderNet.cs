using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using GrpcFileGeneration.Models;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Networking.Providers
{
    public interface IProviderNet
    {
        public Task<User> CreateProviderAsync(Provider provider);
        public Task<Page<ProviderList>> GetAllProvidersAsync(int page);
        Task<Provider> GetProviderByIdAsync(int id);
        Task<Provider> EditProviderAsync(Provider provider);
        Task DeleteProvider(int id);
        Task<Page<ProviderList>> GetAllNotApprovedProvidersAsync(int page);
        Task<Page<ProviderList>> GetAllProvidersByNameAsync(string name, int page);
    }
}