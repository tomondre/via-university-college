using System.Threading.Tasks;
using Person;

namespace FileData
{
    public interface IUserApiService
    {
        Task<User> ValidateUserAsync(string userName, string password);
    }
}