using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components.Authorization;
using WebShop.Cache;
using WebShop.Data.Authentication;
using WebShop.Models;
using StripeCustomer = Stripe.Customer;

namespace WebShop.Services.Customers
{
    public class CustomerService : ICustomerService
    {
        private HttpClient client;
        private readonly AuthenticationStateProvider authenticationStateProvider;
        private readonly ICacheService cacheService;
        private string uri;

        public CustomerService(HttpClient client, AuthenticationStateProvider authenticationStateProvider, ICacheService cacheService)
        {
            this.client = client;
            this.authenticationStateProvider = authenticationStateProvider;
            this.cacheService = cacheService;
            uri = "https://localhost:5001/Customers";
        }

        public async Task CreateCustomerAsync(Customer customer)
        {
            customer.SecurityType = "customer";
            string customerAsJson = JsonSerializer.Serialize(customer);
            var stringContent = new StringContent(customerAsJson, Encoding.UTF8, "application/json");
            var httpResponseMessage = await client.PostAsync(uri, stringContent);

            CheckException(httpResponseMessage);

            var json = await httpResponseMessage.Content.ReadAsStringAsync();
            var deserialize = JsonSerializer.Deserialize<Customer>(json,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            await ((CurrentAuthenticationStateProvider) authenticationStateProvider).ValidateUser(deserialize);
        }

        public async Task<Customer> GetCustomerByIdAsync(int id)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}/{id}");
            HttpResponseMessage response = await client.SendAsync(httpRequestMessage);
            CheckException(response);
            var objAsJson = await response.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Customer>(objAsJson, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
        }

        public async Task<Customer> EditCustomerAsync(Customer customer)
        {
            var httpRequest = await GetHttpRequestAsync(HttpMethod.Patch, $"{uri}/{customer.Id}");
            var json = JsonSerializer.Serialize(customer);
            var stringContent = new StringContent(json, Encoding.UTF8, "application/json");
            httpRequest.Content = stringContent;
            var httpResponseMessage = await client.SendAsync(httpRequest);
            
            CheckException(httpResponseMessage);
            
            var objAsJson = await httpResponseMessage.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Customer>(objAsJson, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
        }

        private void CheckException(HttpResponseMessage task)
        {
            if (!task.IsSuccessStatusCode)
            {
                throw new Exception($"Code: {task.StatusCode}, {task.ReasonPhrase}");
            }
        }

        private async Task<HttpRequestMessage> GetHttpRequestAsync(HttpMethod method, string uri)
        {
            var httpRequestMessage = new HttpRequestMessage(method, uri);
            var token = await cacheService.GetCachedTokenAsync();
            httpRequestMessage.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token);
            //TODO add exception
            return httpRequestMessage;
        }
    }
}