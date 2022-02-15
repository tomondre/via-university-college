using System.Threading.Tasks;
using WebShop.Models;

namespace WebShop.Cache
{
    public interface ICacheService
    {
        Task<User> GetCachedUserAsync();
        Task<string> GetCachedTokenAsync();
        Task SetUserToCacheAsync(User user);
        Task SetTokenToCacheAsync(string token);
    }
}