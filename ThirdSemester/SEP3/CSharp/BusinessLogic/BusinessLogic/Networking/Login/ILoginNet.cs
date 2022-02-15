using System.Threading.Tasks;
using GrpcFileGeneration.Models;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Networking.Login
{
    public interface ILoginNet
    {
        Task<User> GetUserLoginAsync(User userCred);
    }
}