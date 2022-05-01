using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Person;


namespace FileData
{
    public class InMemoryUserRepo : IUserRepo
    {
        public InMemoryUserRepo(IAdultRepo adultRepo)
        {
            Adult administrator = new Adult
            {
                FirstName = "Tomas",
                LastName = "Ondrejka",
                Age = 20,
                Height = 180,
                Sex = "M",
                Weight = 75,
                EyeColor = "Green",
                HairColor = "Black",
                JobTitle = new Job()
                {
                    Salary = 80000,
                    JobTitle = "Software Engineer"
                }
            };

            User user = new User(administrator);
            user.Password = "halabala";
            user.SecurityType = "Administrator";
            user.UserName = "tomondre";


            Adult marketing = new Adult()
            {
                FirstName = "Peter",
                LastName = "Petersen",
                Age = 22,
                Height = 185,
                Sex = "M",
                Weight = 75,
                EyeColor = "Yellow",
                HairColor = "Red",
                JobTitle = new Job()
                {
                    Salary = 70000,
                    JobTitle = "Business Development Manager"
                }
            };

            User market = new User(marketing);
            market.Password = "1234";
            market.SecurityType = "Marketing";
            market.UserName = "TheMarketingGuy";

            using AdultContext adultDao = new AdultContext();
            if (!adultDao.Users.Contains(market))
            {
                adultDao.Users.Add(market);
            }

            if (!adultDao.Users.Contains(user))
            {
                adultDao.Users.Add(user);
            }

            adultDao.SaveChanges();
        }

        public async Task<User> ValidateUserAsync(string username, string password)
        {
            using AdultContext context = new AdultContext();
            var user = context.Users.FirstOrDefault(u => u.Password == password && u.UserName == username);
            if (user == null)
            {
                throw new Exception("Cannot validate");
            }

            return user;
        }
    }
}