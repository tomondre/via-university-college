using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using Networking.User;
using RiskFirst.Hateoas.Models;

namespace ClientBlazor.Models
{
    public class User : ILinkContainer
    {
        public int Id { set; get; }
        [Required, EmailAddress]
        public string Email { get; set; }
        [Required, RegularExpression(@"^(?=.*?[A-Z])(?=.*?[a-z]).{8,14}$",ErrorMessage =
            "The password must be between 8 (included) and 14 (included) characters,\n " +
            "contain at least one number\n" +
            "contain at least one upper case character\n" +
            "contain at least one lower case character")]
        public string Password { get; set; }
        public string Token { set; get; }
        public string SecurityType { set; get; } = "";

        public User()
        {
            Links = new Dictionary<string, Link>();
        }

        public User(User user)
        {
            Links = new Dictionary<string, Link>();
            Email = user.Email;
            Id = user.Id;
            Password = user.Password;
            SecurityType = user.SecurityType;
            Token = user.Token;
        }
        
        public User(UserMessage message)
        {
            Links = new Dictionary<string, Link>();
            Id = message.Id;
            Email = message.Email;
            Password = message.Password;
            SecurityType = message.SecurityType;
        }

        public UserMessage ToMessage()
        {
            return new UserMessage()
            {
                Email = this.Email,
                Id = this.Id,
                Password = this.Password,
                SecurityType = this.SecurityType
            };
        }

        public void AddLink(string id, Link link)
        {
            if (!Links.ContainsKey(id))
            {
                Links.Add(id, link);
            }
        }

        public Dictionary<string, Link> Links { get; set; }
    }
}