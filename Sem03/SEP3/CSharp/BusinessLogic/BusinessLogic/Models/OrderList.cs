using System.Collections.Generic;
using BusinessLogic.Models.Orders;

namespace BusinessLogic.Models
{
    public class OrderList
    {
        public IList<Order> Orders { get; set; }

        public OrderList()
        {
            Orders = new List<Order>();
        }
    }
}