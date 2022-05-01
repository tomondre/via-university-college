using System;
using System.Text.Json;
using System.Threading.Tasks;
using FileData;
using Microsoft.AspNetCore.Mvc;
using Person;

namespace API.Controllers
{
    [ApiController]
    [Route("Users")]
    public class UserController : ControllerBase
    {
        public int Id { get; set; }
        private IUserRepo userRepo;

        public UserController(IUserRepo userRepo)
        {
            this.userRepo = userRepo;
        }

        [HttpPost]
        public async Task<User> ValidateUser([FromBody] User user)
        {
            try
            {
                var validateUser = await userRepo.ValidateUserAsync(user.UserName, user.Password);
                return validateUser;
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
            return null;
            
        }
    }
}