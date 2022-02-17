using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using GrpcFileGeneration.Models;
using Networking.Customer;
using RiskFirst.Hateoas.Models;

namespace ClientBlazor.Models
{
    public class Customer : User, ILinkContainer
    {
        [Required, MaxLength(50)]
        public string FirstName { get; set; }
        [Required, MaxLength(50)]
        public string LastName { get; set; }

        [Required, MaxLength(20)]
        public string PhoneNumber { get; set; }
        
        [Required]
        public Address Address { get; set; }

        public Dictionary<string, Link> Links { set; get; }

        public void AddLink(string id, Link link)
        {
            Links.Add(id, link);
        }

        public Customer()
        {
            Address = new Address();
            Links = new Dictionary<string, Link>();
        }

        public Customer(CustomerMessage message) : base(message.UserMessage)
        {
            Links = new Dictionary<string, Link>();
            Address = new Address(message.Address);
            FirstName = message.FirstName;
            LastName = message.LastName;
            PhoneNumber = message.PhoneNumber;
        }

        public CustomerMessage ToMessage()
        {
            return new CustomerMessage()
            {
                Address = Address.ToMessage(),
                FirstName = this.FirstName,
                LastName = this.LastName,
                PhoneNumber = this.PhoneNumber,
                UserMessage = base.ToMessage()
            };
        }
    }
}