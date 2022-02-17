using System.Threading.Tasks;
using WebShop.Models;
using WebShop.Models.Orders;
using OrderStripe = Stripe.Order;
using Order = WebShop.Models.Orders.Order;

namespace WebShop.Services.Orders
{
    public interface IOrderService
    {
        Task<int> CreateOrderAsync(Order order);
        Task<Order> GetOrderByIdAsync(int id);
        Task<Page<OrderList>> GetCustomerOrdersAsync(int id, int page);
    }
}