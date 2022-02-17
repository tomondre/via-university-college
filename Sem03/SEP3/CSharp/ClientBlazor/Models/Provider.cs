using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using GrpcFileGeneration.Models;
using Networking.Provider;
using RiskFirst.Hateoas.Models;

namespace ClientBlazor.Models
{
    public class Provider : User, ILinkContainer
    {
        public Dictionary<string, Link> Links { set; get; }
        
        [Required, MaxLength(50)]
        public string CompanyName { get; set; }
        [Required, Range(10000000,99999999)]
        public int Cvr { get; set; }
        [Required, MaxLength(20)]
        public string PhoneNumber { get; set; }
        [Required, MaxLength(500)]
        public string Description { get; set; }
        
        public bool IsApproved { set; get; }

        [ValidateComplexType]
        public Address Address { get; set; }


        public Provider()
        {
            Links = new Dictionary<string, Link>();
            Address = new Address();
        }

        public Provider(Provider provider)
        {
            Address = provider.Address;
            Cvr = provider.Cvr;
            Description = provider.Description;
            Links = new Dictionary<string, Link>();
            CompanyName = provider.CompanyName;
            IsApproved = provider.IsApproved;
            PhoneNumber = provider.PhoneNumber;
            Email = provider.Email;
            Id = provider.Id;
            Password = provider.Password;
            Token = provider.Token;
            SecurityType = provider.SecurityType;
        }

        public Provider(ProviderMessage message) : base(message.User)
        {
            Links = new Dictionary<string, Link>();
            CompanyName = message.CompanyName;
            Cvr = message.Cvr;
            Description = message.Description;
            PhoneNumber = message.PhoneNumber;
            IsApproved = message.IsApproved;
            Address = new Address(message.Address);
        }

        public ProviderMessage ToMessage()
        {
            return new ProviderMessage()
            {
                Address = Address.ToMessage(),
                Cvr = Cvr,
                Description = Description,
                CompanyName = CompanyName,
                IsApproved = IsApproved,
                PhoneNumber = PhoneNumber,
                User = base.ToMessage()
            };
        }
        public void AddLink(string id, Link link)
        {
            if (!Links.ContainsKey(id))
            {
                Links.Add(id, link);
            }
        }
        
    }
}