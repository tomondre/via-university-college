using System;
using System.Collections.Generic;
using System.Linq;
using S04_Ex03_Prep.Models;

namespace S04_Ex03_Prep.Data
{
    public class UserService : IUserService
    {
        private IList<User> users;

        public UserService()
        {
            users = new List<User>()
            {
                new User()
                {
                    UserName = "Tomas",
                    Password = "Password"
                },
                new User()
                {
                    UserName = "Petersen",
                    Password = "1234"
                }
            };
        }

        public void ValidateLogin(User user)
        {
            var first = users.First((u) => u.UserName == user.UserName);
            if (!(first.Password == user.Password))
            {
                throw new Exception("Not Valid");
            }
        }
    }
}