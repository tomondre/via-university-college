using System.Collections.Generic;
using ClientBlazor.Models.Orders;

namespace ClientBlazor.Models
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