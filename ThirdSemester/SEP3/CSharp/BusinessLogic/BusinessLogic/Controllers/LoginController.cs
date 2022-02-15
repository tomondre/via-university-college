using System;
using System.Threading.Tasks;
using BusinessLogic.Model.Login;
using GrpcFileGeneration.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Controllers
{
    [Authorize]
    [ApiController]
    [Route("[controller]")]
    public class LoginController : ControllerBase
    {
        private ILoginModel model;

        public LoginController(ILoginModel model)
        {
            this.model = model;
        }
        
        [AllowAnonymous]
        [HttpPost]
        public async Task<ActionResult<User>> AuthenticateUser([FromBody] User userCred)
        {
            try
            {
                var authenticate = await model.AuthenticateUserAsync(userCred);
                return Ok(authenticate);
            }
            catch (Exception e)
            {
                return StatusCode(401, e.Message);
            }
         
        }
    }
}