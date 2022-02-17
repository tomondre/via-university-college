using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using RiskFirst.Hateoas.Models;

namespace WebShop.Models
{
    public class Category : ILinkContainer
    {
        public Dictionary<string, Link> Links { set; get; }
        public int Id { set; get; }

        [Required(ErrorMessage = "Please add a category name")]
        
        public string CategoryName { get; set; }


        public Category()
        {
            Links = new Dictionary<string, Link>();
        }

        public void AddLink(string id, Link link)
        {
            Links.Add(id, link);
        }

        public override string ToString()
        {
            return $"{Id} {CategoryName}";
        }
    }
}