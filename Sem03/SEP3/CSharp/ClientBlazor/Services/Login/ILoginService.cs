using System.Threading.Tasks;
using User = ClientBlazor.Models.User;

namespace ClientBlazor.Services.Login
{
    public interface ILoginService
    {
        Task<User> ValidateUser(User userCred);
    }
}