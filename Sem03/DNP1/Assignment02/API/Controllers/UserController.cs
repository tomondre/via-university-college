using System;
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
        private IUserService userService;

        public UserController(IUserService userService)
        {
            this.userService = userService;
        }



        [HttpPost]
        public async Task<User> ValidateUser([FromBody] User user)
        {
            try
            {
                var validateUser = await userService.ValidateUserAsync(user.UserName, user.Password);
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
