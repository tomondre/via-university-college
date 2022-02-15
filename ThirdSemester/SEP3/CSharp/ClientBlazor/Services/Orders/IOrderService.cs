using System.Threading.Tasks;
using ClientBlazor.Models;
using GrpcFileGeneration.Models;
using Order = ClientBlazor.Models.Orders.Order;

namespace ClientBlazor.Services.Orders
{
    public interface IOrderService
    {
        Task<Order> GetOrderByIdAsync(int id);
        Task<Page<OrderList>> GetCustomerOrdersAsync(int id, int page);
        Task<Page<ProvidersVoucherList>> GetAllProviderVouchersAsync(int page);
    }
}