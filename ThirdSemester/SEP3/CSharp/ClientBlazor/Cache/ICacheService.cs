using System.Threading.Tasks;
using User = ClientBlazor.Models.User;

namespace ClientBlazor.Cache
{
    public interface ICacheService
    {
        Task<User> GetCachedUserAsync();
        Task<string> GetCachedTokenAsync();

        Task SetUserToCacheAsync(User user);
        Task SetTokenToCacheAsync(string token);
    }
}