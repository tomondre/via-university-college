using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using GrpcFileGeneration.Models;
using Networking.Customer;
using Networking.Request;
using Networking.User;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Networking.Customers
{
    public class CustomerNet : ICustomerNet
    {
        private CustomerService.CustomerServiceClient client;

        public CustomerNet(CustomerService.CustomerServiceClient client)
        {
            this.client = client;
        }

        public async Task<User> CreateCustomerAsync(Customer customer)
        {
            CustomerMessage customerMessage = new CustomerMessage(customer.ToMessage());
            var protobufMessage = await client.createCustomerAsync(customerMessage);
            var user = new User(protobufMessage);
            return user;
        }

        public async Task<Page<CustomerList>> GetAllCustomersAsync(int pageRequest)
        {
            var pageRequestMessage = new PageRequestMessage {PageNumber = pageRequest, PageSize = 5};
            CustomersMessage response = await client.getAllCustomersAsync(pageRequestMessage);
            
            var customersMessage = response.Customers;
            var customers = new CustomerList()
            {
                Customers = customersMessage.Select(a => new Customer(a)).ToList()
            };
            
            var customersPage = new Page<CustomerList>(response.Page)
            {
                Content = customers
            };
            return customersPage;
        }

        public async Task DeleteCustomerAsync(int customerId)
        {
           await client.deleteCustomerAsync(new UserMessage() {Id = customerId});
        }

        public async Task<Customer> GetCustomerByIdAsync(int id)
        {
            UserMessage userMessage = new UserMessage{Id = id};
            CustomerMessage customerByIdMessage = await client.getCustomerByIdAsync(userMessage);
            Customer customerById = new Customer(customerByIdMessage);
            return customerById;
        }

        public async Task<Customer> EditCustomerAsync(Customer customer)
        {
            CustomerMessage editedCustomer = await client.editCustomerAsync(customer.ToMessage());
            return new Customer(editedCustomer);

        }

        public async Task<Page<CustomerList>> FindCustomerByNameAsync(string name, int pageRequest)
        {
            var pageRequestMessage = new PageRequestMessage() {PageNumber = pageRequest, PageSize = 5};
            var requestMessage = new RequestMessage() {Name = name, PageInfo = pageRequestMessage};
            var response = await client.findCustomerByNameAsync(requestMessage);
            
            var customersMessage = response.Customers;
            var customers = new CustomerList()
            {
                Customers = customersMessage.Select(a => new Customer(a)).ToList()
            };
            
            var customersPage = new Page<CustomerList>(response.Page)
            {
                Content = customers
            };
            return customersPage;
        }
    }
}