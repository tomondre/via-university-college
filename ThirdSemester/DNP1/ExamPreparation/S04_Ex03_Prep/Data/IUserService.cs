using S04_Ex03_Prep.Models;

namespace S04_Ex03_Prep.Data
{
    public interface IUserService
    {
        void ValidateLogin(User user);
    }
}