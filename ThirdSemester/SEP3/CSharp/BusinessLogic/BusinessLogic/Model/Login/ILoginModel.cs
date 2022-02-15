using System.Threading.Tasks;
using GrpcFileGeneration.Models;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Model.Login
{
    public interface ILoginModel
    {
        Task<User> AuthenticateUserAsync(User userCred); 
    }
}