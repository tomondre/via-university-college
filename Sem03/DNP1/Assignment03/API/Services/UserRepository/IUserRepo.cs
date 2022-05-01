using System.Threading.Tasks;
using Person;

namespace FileData
{
    public interface IUserRepo
    {
        Task<User> ValidateUserAsync(string username, string password);
    }
}