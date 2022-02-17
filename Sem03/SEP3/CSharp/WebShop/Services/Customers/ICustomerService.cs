using System.Threading.Tasks;
using WebShop.Models;
using StripeCustomer = Stripe.Customer;

namespace WebShop.Services.Customers
{
    public interface ICustomerService
    { 
        Task CreateCustomerAsync(Customer customer);
        Task<Customer> GetCustomerByIdAsync(int id);
        Task<Customer> EditCustomerAsync(Customer customer);
    }
}