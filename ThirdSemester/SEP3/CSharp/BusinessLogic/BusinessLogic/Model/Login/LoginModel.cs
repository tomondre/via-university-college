using System;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using BusinessLogic.Networking.Login;
using GrpcFileGeneration.Models;
using Microsoft.IdentityModel.Tokens;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Model.Login
{
    public class LoginModel :ILoginModel
    {
        private ILoginNet net;
        private readonly string key;

        public LoginModel(ILoginNet net, string key)
        {
            this.net = net;
            this.key = key;
        }

        public async Task<User> AuthenticateUserAsync(User userCred)
        {
            var userLoginAsync = await net.GetUserLoginAsync(userCred);
            if (userLoginAsync == null)
            {
                return null;
            }

            userLoginAsync.Token = WriteToken(userLoginAsync);
            return userLoginAsync;
        }

        private string WriteToken(User userCred)
        {
            var jwtSecurityTokenHandler = new JwtSecurityTokenHandler();
            var tokenKey = Encoding.ASCII.GetBytes(key);
            var securityTokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                    new Claim(ClaimTypes.Name, userCred.Email),
                    new Claim(ClaimTypes.Role, userCred.SecurityType)
                }),
                Expires = DateTime.UtcNow.AddHours(1),
                SigningCredentials =
                    new SigningCredentials(new SymmetricSecurityKey(tokenKey), SecurityAlgorithms.HmacSha256)
            };
            var securityToken = jwtSecurityTokenHandler.CreateToken(securityTokenDescriptor);
            var writeToken = jwtSecurityTokenHandler.WriteToken(securityToken);
            return writeToken;
        }

    }
}