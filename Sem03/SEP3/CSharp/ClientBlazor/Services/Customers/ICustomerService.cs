using System.Threading.Tasks;
using ClientBlazor.Models;
using GrpcFileGeneration.Models;
using CustomerList = ClientBlazor.Models.Orders.CustomerList;

namespace ClientBlazor.Services.Customers
{
    public interface ICustomerService
    {
        Task<Page<CustomerList>> GetAllCustomersAsync(int pageNumber);
        Task DeleteCustomer(Customer customer);
        Task<Page<CustomerList>> GetAllCustomersByNameAsync(string name, int pageNumber);
    }
}