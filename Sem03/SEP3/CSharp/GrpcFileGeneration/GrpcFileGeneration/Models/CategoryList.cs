using System.Collections.Generic;
using RiskFirst.Hateoas.Models;

namespace GrpcFileGeneration.Models
{
    public class CategoryList : ILinkContainer
    {
        public IList<Category> Categories { get; set; }
        public Dictionary<string, Link> Links { get; set; }

        public CategoryList()
        {
            Categories = new List<Category>();
            Links = new Dictionary<string, Link>();
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