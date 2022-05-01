using System.Threading.Tasks;
using Person;

namespace FileData
{
    public interface IUserService
    {
        Task<User> ValidateUserAsync(string username, string password);
    }
}