using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using RiskFirst.Hateoas.Models;

namespace WebShop.Models.Orders
{
    public class Order : ILinkContainer
    {
        public int Id { get; set; }
        public Customer Customer { get; set; }
        public ShoppingCart ShoppingCart { get; set; }
        [ValidateComplexType]
        public CreditCard CreditCard { get; set; }
        public string Comment { get; set; } = "";
        public string PaymentId { get; set; }
        public string Date { get; set; }

        public Order()
        {
            Links = new Dictionary<string, Link>();
            Customer = new();
            ShoppingCart = new();
            CreditCard = new();
        }

        public void RemoveCreditCardInformation()
        {
            CreditCard = new();
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