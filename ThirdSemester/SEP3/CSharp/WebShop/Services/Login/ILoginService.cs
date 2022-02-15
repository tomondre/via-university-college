using System.Threading.Tasks;
using WebShop.Models;

namespace WebShop.Services.Login
{
    public interface ILoginService
    {
        Task<User> ValidateUser(User userCred);
    }
}