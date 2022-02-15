using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.Json;
using System.Threading.Tasks;
using ClientBlazor.Cache;
using ClientBlazor.Models;
using GrpcFileGeneration.Models;
using CustomerList = ClientBlazor.Models.Orders.CustomerList;

namespace ClientBlazor.Services.Customers
{
    public class CustomerService : ICustomerService
    {
        private readonly ICacheService cacheService;
        private HttpClient client;
        private string uri;

        public CustomerService(ICacheService cacheService)
        {
            this.cacheService = cacheService;
            client = new HttpClient();
            uri = "https://localhost:5001/Customers";
        }

        public async Task<Page<CustomerList>> GetAllCustomersAsync(int pageNumber)
        {
            var httpRequestMessage = await GetHttpRequest(HttpMethod.Get, $"{uri}?page={pageNumber}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);

            CheckException(httpResponseMessage);

            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var customerList = JsonSerializer.Deserialize<Page<CustomerList>>(readAsStringAsync,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return customerList;
        }

        public async Task DeleteCustomer(Customer customer)
        {
            var httpRequestMessage = await GetHttpRequest(HttpMethod.Delete, $"{uri}/{customer.Id}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);

            CheckException(httpResponseMessage);
        }

        public async Task<Page<CustomerList>> GetAllCustomersByNameAsync(string name, int pageNumber)
        {
            var httpRequestMessage = await GetHttpRequest(HttpMethod.Get, $"{uri}?name={name}&page={pageNumber}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);

            CheckException(httpResponseMessage);

            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var customerList = JsonSerializer.Deserialize<Page<CustomerList>>(readAsStringAsync,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return customerList;
        }

        private async Task<HttpRequestMessage> GetHttpRequest(HttpMethod method, string uri)
        {
            var httpRequestMessage = new HttpRequestMessage(method, uri);
            var token = await cacheService.GetCachedTokenAsync();
            httpRequestMessage.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token);
            //TODO add exception
            return httpRequestMessage;
        }

        private void CheckException(HttpResponseMessage task)
        {
            if (!task.IsSuccessStatusCode)
            {
                throw new Exception($"Code: {task.StatusCode}, {task.ReasonPhrase} ");
            }
        }
    }
}