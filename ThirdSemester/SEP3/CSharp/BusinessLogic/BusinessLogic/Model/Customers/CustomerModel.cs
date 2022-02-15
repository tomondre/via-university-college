using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using BusinessLogic.Networking.Customers;
using GrpcFileGeneration.Models;
using User = BusinessLogic.Models.User;


// TODO data validation
namespace BusinessLogic.Model.Customers
{
    public class CustomerModel : ICustomerModel
    {
        private ICustomerNet network;

        public CustomerModel(ICustomerNet network)
        {
            this.network = network;
        }
        
        public Task<User> CreateCustomerAsync(Customer customer)
        {
            return network.CreateCustomerAsync(customer);
        }

        public async Task<Page<CustomerList>> GetAllCustomersAsync(int pageRequest)
        {
            return await network.GetAllCustomersAsync(pageRequest);
        }

        public async Task DeleteCustomerAsync(int customerId)
        {
            await network.DeleteCustomerAsync(customerId);
        }

        public async Task<Page<CustomerList>> FindCustomerByNameAsync(string name, int pageRequest)
        {
            return await network.FindCustomerByNameAsync(name, pageRequest);
        }

        public async Task<Customer> GetCustomerByIdAsync(int id)
        {
            return await network.GetCustomerByIdAsync(id);
        }

        public async Task<Customer> EditCustomerAsync(Customer customer)
        {
            return await network.EditCustomerAsync(customer);
        }
    }
}