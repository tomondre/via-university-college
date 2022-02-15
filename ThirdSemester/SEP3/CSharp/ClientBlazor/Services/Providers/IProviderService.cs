using System.Threading.Tasks;
using GrpcFileGeneration.Models;
using Provider = ClientBlazor.Models.Provider;
using ProviderList = ClientBlazor.Models.Orders.ProviderList;

namespace ClientBlazor.Services.Providers
{
    public interface IProviderService
    {
        public Task CreateProvider(Provider provider);
        public Task<Page<ProviderList>> GetAllProviders(int page);
        Task<Provider> GetProviderById(int id);
        Task<Provider> EditProvider(Provider provider);
        Task DeleteProviderAsync(Provider provider);
        Task<Page<ProviderList>> GetAllNotApprovedProvidersAsync(int page);
        Task<Page<ProviderList>> GetAllProvidersByNameAsync(string name, int page);
    }
}