using System.Collections.Generic;
using RiskFirst.Hateoas.Models;

namespace WebShop.Models
{
    public class ExperienceList : ILinkContainer
    {
        public IList<Experience> Experiences { get; set; }

        public ExperienceList()
        {
            Links = new Dictionary<string, Link>();
            Experiences = new List<Experience>();
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