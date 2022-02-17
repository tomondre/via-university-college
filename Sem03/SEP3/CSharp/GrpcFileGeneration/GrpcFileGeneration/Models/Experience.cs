using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Security.Cryptography;
using System.Threading;
using Networking.Address;
using Networking.Experience;
using RiskFirst.Hateoas.Models;

namespace GrpcFileGeneration.Models
{
    public class Experience : ILinkContainer
    {
        public int Id { get;  set; }
        public string Picture { get; set; } = "";
        
        [Required, MaxLength(50)]
        public string Name { get; set; }
        
        [Required]
        public double Price { get; set; }
        
        [Required]
        public int Stock { get;  set; }
        
        [Required, MaxLength(500)]
        public string Description { get; set; }
        [Required]       
        public int ExperienceValidity { get; set; }
        [Required]
        public int CategoryId { get; set; }
        
        public  int ProviderId { get; set; }
        [ValidateComplexType]
        public Address Address { get; set; }

        public Experience()
        {
            Links = new Dictionary<string, Link>();
            Address = new Address();
        }

        public Experience(ExperienceMessage e)
        {
            Links = new Dictionary<string, Link>();
            Id = e.Id;
            Picture = e.Picture;
            Name = e.Name;
            Price = e.Price;
            Stock = e.Stock;
            Description = e.Description;
            ExperienceValidity = e.ExperienceValidity;
            CategoryId = e.CategoryId;
            ProviderId = e.ProviderId;
            Address = new Address(e.Address);
        }

        public ExperienceMessage ToMessage()
        {
            return new ExperienceMessage
            {
                Id = Id,
                Address = Address.ToMessage(),
                Description = Description,
                Name = Name,
                Price = Price,
                Picture = Picture,
                Stock = Stock,
                CategoryId = CategoryId,
                ExperienceValidity = ExperienceValidity,
                ProviderId = ProviderId
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