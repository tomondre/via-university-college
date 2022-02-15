using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using Networking.User;
using RiskFirst.Hateoas.Models;

namespace BusinessLogic.Models
{
    public class User : ILinkContainer
    {
        public int Id { set; get; }
        [Required, EmailAddress]
        public string Email { get; set; }
        [Required, RegularExpression(@"\b[A-Fa-f0-9]{64}\b",ErrorMessage =
            "Password needs to be a hash key")]
        public string Password { get; set; }
        public string Token { set; get; }
        public string SecurityType { set; get; } = "";

        public User()
        {
            Links = new Dictionary<string, Link>();
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