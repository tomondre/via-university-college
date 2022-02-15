using System.Collections.Generic;

namespace WebShop.Models.Orders
{
    public class ShoppingCart
    {
        public IList<ExperienceCartItem> ShoppingCartItems { get; set; }
        public int Tax { get; }
        public ShoppingCart()
        {
            ShoppingCartItems = new List<ExperienceCartItem>();
            Tax = 25;
        }

        public double OrderTotal
        {
            get
            {
                double total = 0;
                foreach (var item in ShoppingCartItems)
                {
                    total += item.TotalPrice;
                }
                
                return total;
            }
        }

        public double TaxAmount => OrderTotal - (OrderTotal / (1 + (double) Tax / 100));
    }
}