using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using RiskFirst.Hateoas.Models;

namespace WebShop.Models
{
    public class Customer : User, ILinkContainer
    {
        [Required, MaxLength(50)]
        public string FirstName { get; set; }
        [Required, MaxLength(50)]
        public string LastName { get; set; }

        [Required, MaxLength(20)]
        public string PhoneNumber { get; set; }
        
        [ValidateComplexType]
        public Address Address { get; set; }

        public Dictionary<string, Link> Links { set; get; }

        public Customer()
        {
            Address = new Address();
            Links = new Dictionary<string, Link>();
        }

        public Customer(Customer customer)
        {
            Address = customer.Address;
            Links = customer.Links;
            FirstName = customer.FirstName;
            LastName = customer.LastName;
            PhoneNumber = customer.PhoneNumber;
            Email = customer.Email;
            Id = customer.Id;
            Token = customer.Token;
            SecurityType = customer.SecurityType;
            Password = customer.Password;
        }

        public void AddLink(string id, Link link)
        {
            Links.Add(id, link);
        }
    }
}