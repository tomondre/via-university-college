using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using GrpcFileGeneration.Models;
using GrpcFileGeneration.Models.Orders;

namespace BusinessLogic.Model.Orders
{
    public interface IOrderModel
    {
        Task<Order> CreateOrderAsync(Order order);
        Task<Page<OrderList>> GetAllCustomerOrdersAsync(int id, int page);
        Task<Order> GetOrderByIdAsync(int id);
        Task<Page<ProvidersVoucherList>> GetProvidersVouchersAsync(int id, int page);
    }
}