using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.Json;
using System.Threading.Tasks;
using ClientBlazor.Cache;
using ClientBlazor.Models;
using GrpcFileGeneration.Models;
using Order = ClientBlazor.Models.Orders.Order;

namespace ClientBlazor.Services.Orders
{
    public class OrderService : IOrderService
    {
        private HttpClient client;
        private readonly ICacheService cacheService;
        private string url = "https://localhost:5001/";
        
        public OrderService(HttpClient client, ICacheService cacheService)
        {
            this.client = client;
            this.cacheService = cacheService;
        }

        public async Task<Order> GetOrderByIdAsync(int id)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{url}orders/{id}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var deserialize = JsonSerializer.Deserialize<Order>(readAsStringAsync,
                new JsonSerializerOptions {PropertyNamingPolicy = JsonNamingPolicy.CamelCase});
            return deserialize;
        }

        public async Task<Page<OrderList>> GetCustomerOrdersAsync(int id, int page)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{url}customers/{id}/orders?page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var orderList = JsonSerializer.Deserialize<Page<OrderList>>(readAsStringAsync, new JsonSerializerOptions {PropertyNamingPolicy = JsonNamingPolicy.CamelCase});
            return orderList;
        }

        public async Task<Page<ProvidersVoucherList>> GetAllProviderVouchersAsync(int page)
        {
            var cachedUserAsync = await cacheService.GetCachedUserAsync();
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{url}providers/{cachedUserAsync.Id}/vouchers?page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var orderList = JsonSerializer.Deserialize<Page<ProvidersVoucherList>>(readAsStringAsync, new JsonSerializerOptions {PropertyNamingPolicy = JsonNamingPolicy.CamelCase});
            return orderList;
        }
        
        private async Task<HttpRequestMessage> GetHttpRequestAsync(HttpMethod method, string uri)
        {
            var httpRequestMessage = new HttpRequestMessage(method, uri);
            var cachedTokenAsync = await cacheService.GetCachedTokenAsync();
            httpRequestMessage.Headers.Authorization = new AuthenticationHeaderValue("Bearer", cachedTokenAsync);
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