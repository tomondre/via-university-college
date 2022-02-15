using System;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Model.Customers;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using GrpcFileGeneration.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using RiskFirst.Hateoas;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Controllers
{
    [Authorize]
    [ApiController]
    [Route("[controller]")]
    public class CustomersController : ControllerBase
    {
        private ICustomerModel model;
        private ILinksService linksService;

        public CustomersController(ILinksService linksService, ICustomerModel model)
        {
            this.linksService = linksService;
            this.model = model;
        }
        
        [AllowAnonymous]
        [HttpPost(Name = "CreateCustomerRoute")]
        public async Task<ActionResult<User>> CreateCustomer([FromBody] Customer customer)
        {
            try
            {
                var customerAsync = await model.CreateCustomerAsync(customer);
                return Ok(customerAsync);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [Authorize(Roles = "administrator")]
        [HttpGet(Name = "GetAllCustomersRoute")]
        public async Task<ActionResult<Page<CustomerList>>> GetAllCustomersAsync([FromQuery(Name = "name")] string name, [FromQuery(Name = "page")] int pageNumber)
        {
            try
            {
                Page<CustomerList> allCustomersAsync = new();
                if (string.IsNullOrEmpty(name))
                {
                    allCustomersAsync = await model.GetAllCustomersAsync(pageNumber);
                }
                else
                {
                    allCustomersAsync = await model.FindCustomerByNameAsync(name, pageNumber);
                }

                await AddLinks(allCustomersAsync.Content);
                return Ok(allCustomersAsync);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
            
        }

        [Authorize(Roles = "administrator")]
        [HttpDelete("{id:int}", Name = "DeleteCustomerRoute")]
        public async Task<ActionResult> DeleteCustomer([FromRoute] int id)
        {
            await model.DeleteCustomerAsync(id);
            return Ok();
        }
        
        [Authorize(Roles = "customer")]
        [HttpGet("{id:int}", Name = "GetCustomerByIdRoute")]
        public async Task<ActionResult<User>> GetCustomerById([FromRoute] int id)
        {
            try
            {
                var providerById = await model.GetCustomerByIdAsync(id);
                await AddLink(providerById);
                return Ok(providerById);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
      
        }
        
        [Authorize(Roles = "customer")]
        [HttpPatch("{id:int}",Name = "EditCustomerRoute")]
        public async Task<ActionResult<Customer>> EditCustomer([FromBody] Customer customer)
        {
            try
            {
                Customer editedCustomer = await model.EditCustomerAsync(customer);
                await AddLink(editedCustomer);
                return Ok(editedCustomer);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
           
        }

        private async Task AddLink(Customer customer)
        {
            try
            {
                await linksService.AddLinksAsync(customer);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }

        private async Task AddLinks(CustomerList list)
        {
            try
            {
                foreach (var c  in list.Customers)
                {
                    await linksService.AddLinksAsync(c);
                }

                await linksService.AddLinksAsync(list);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }
    }
}