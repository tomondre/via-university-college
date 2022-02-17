using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using RiskFirst.Hateoas.Models;

namespace WebShop.Models
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

        public int CategoryId { get; set; }
        
        public  int ProviderId { get; set; }
        
        public Address Address { get; set; }

        public Experience()
        {
            Links = new Dictionary<string, Link>();
            Address = new Address();
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