using System.Text.Json;
using System.Threading.Tasks;
using GrpcFileGeneration.Models;
using Networking.Login;
using Networking.User;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Networking.Login
{
    public class LoginNet : ILoginNet
    {
        private LoginService.LoginServiceClient client;

        public LoginNet(LoginService.LoginServiceClient client)
        {
            this.client = client;
        }
        
        public async Task<User> GetUserLoginAsync(User user)
        {
            var userMessage = user.ToMessage();
            var loginAsync = await client.GetUserLoginAsync(userMessage);
            var messageOrObject = new User(loginAsync);
            return messageOrObject;
        }
    }
}