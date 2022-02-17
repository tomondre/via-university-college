using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Stripe;
using WebShop.Cache;
using WebShop.Models;
using WebShop.Models.Orders;
using OrderStripe = Stripe.Order;
using Order = WebShop.Models.Orders.Order;

namespace WebShop.Services.Orders
{
    public class OrderService : IOrderService
    {
        private HttpClient client;
        private readonly ICacheService cacheService;
        private string secretKey = "sk_test_51JyZa3HP6RYbC1HUXv6ohA4Hz6PiePRCQUdo0R6xGXDqvnEKc8E95CobkUpAj12nvHqyuhASAMtEsxfDSyHKkh3S00KY0zYi2B";
        private string url = "https://localhost:5001/";
        
        public OrderService(HttpClient client, ICacheService cacheService)
        {
            this.client = client;
            this.cacheService = cacheService;
            StripeConfiguration.ApiKey = secretKey;
        }

        public async Task<int> CreateOrderAsync(Order order)
        {
            //Step 1 - CreatePaymentMethod from stripe and receive payment id
            var options = new PaymentMethodCreateOptions
            {
                Type = "card",
                Card = new PaymentMethodCardOptions
                {
                    Number = order.CreditCard.Number,
                    ExpMonth = order.CreditCard.Month,
                    ExpYear = order.CreditCard.Year,
                    Cvc = order.CreditCard.Cvv
                }
            };
            var paymentMethodService = new PaymentMethodService();
            var paymentMethod = await paymentMethodService.CreateAsync(options);
            
            //Step 2 - Remove credit card information for safety
            order.RemoveCreditCardInformation();

            //Step 3 - Add Payment method id to order
            order.PaymentId = paymentMethod.Id;
            
            //Step 4 - Send order to rest api
            var serialize = JsonSerializer.Serialize(order);
            var stringContent = new StringContent(serialize, Encoding.UTF8, "application/json");
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Post, $"{url}orders");
            httpRequestMessage.Content = stringContent;
            var postAsync =  await client.SendAsync(httpRequestMessage);
            
            //Step 5 - Check exception
            CheckException(postAsync);
            
            //Step 6 - Deserialize
            var readAsStringAsync = await postAsync.Content.ReadAsStringAsync();
            var deserialize = JsonSerializer.Deserialize<Order>(readAsStringAsync, new JsonSerializerOptions(){PropertyNamingPolicy = JsonNamingPolicy.CamelCase});

            //Step 7 - Return Id of created order
            return deserialize.Id;
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