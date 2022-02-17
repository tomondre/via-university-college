using System.Threading.Tasks;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using GrpcFileGeneration.Models;
using OrderStripe = Stripe.Order;

namespace BusinessLogic.Networking.Orders
{
    public interface IOrderNet
    {
        Task<Order> CreateOrderAsync(Order order);
        Task<Page<OrderList>> GetAllCustomerOrdersAsync(int id, int page);
        Task<Order> GetOrderByIdAsync(int id);
        Task<Page<ProvidersVoucherList>> GetProvidersVouchersAsync(int id, int page);
    }
}