using Person;

namespace FileData
{
    public interface IUserService
    {
        User ValidateUser(string username, string password);
    }
}