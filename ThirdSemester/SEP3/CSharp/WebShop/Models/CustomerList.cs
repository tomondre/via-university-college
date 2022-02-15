using System.Collections.Generic;
using RiskFirst.Hateoas.Models;

namespace WebShop.Models
{
    public class CustomerList : ILinkContainer
    {
        public Dictionary<string, Link> Links { get; set; }
        public IList<Customer> Customers { set; get; }

        public CustomerList()
        {
            Links = new Dictionary<string, Link>();
            Customers = new List<Customer>();
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