using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using BusinessLogic.Model.Experiences;
using BusinessLogic.Models;
using BusinessLogic.Networking.Experiences;
using BusinessLogic.Networking.Orders;
using GrpcFileGeneration.Models;
using GrpcFileGeneration.Models.Orders;
using Microsoft.Extensions.Caching.Memory;
using Newtonsoft.Json.Linq;
using Stripe;
using Order = BusinessLogic.Models.Orders.Order;


namespace BusinessLogic.Model.Orders
{
    public class OrderModel : IOrderModel
    {
        private IOrderNet networking;
        private string secretKey = "sk_test_51JyZa3HP6RYbC1HUXv6ohA4Hz6PiePRCQUdo0R6xGXDqvnEKc8E95CobkUpAj12nvHqyuhASAMtEsxfDSyHKkh3S00KY0zYi2B";
        private readonly string pdfUri = "https://us1.pdfgeneratorapi.com/api/v3/templates/352674/output?name=My%20document&format=pdf&output=url";
        private readonly string pdfToken =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJiZjI1NzI4YWRjMTZiNjJmODljN2U5NDJjNzc1MDViZDg1ODMzYjczMTAwNGY1MWZmMGYyZjI2NWEwYmY0YTE3IiwiaWF0IjpudWxsLCJleHAiOjE2Njk4MDk3OTMsImF1ZCI6IiIsInN1YiI6IjI3NTI0MUB2aWF1Yy5kayJ9.V3UGyDTTSYaDHv8Pb2qaK25GuGSKmVyYF-p2m9bTudc";
        private IExperienceModel experienceNet;
        private IMemoryCache memoryCache;

        public OrderModel(IOrderNet networking, IExperienceModel experienceNet, IMemoryCache memoryCache)
        {
            this.networking = networking;
            this.experienceNet = experienceNet;
            StripeConfiguration.ApiKey = secretKey;
            this.memoryCache = memoryCache;
        }

        public async Task<Page<OrderList>> GetAllCustomerOrdersAsync(int id, int page)
        {
            return await networking.GetAllCustomerOrdersAsync(id, page);
        }

        public async Task<Order> GetOrderByIdAsync(int id)
        {
            return await networking.GetOrderByIdAsync(id);
        }

        public async Task<Page<ProvidersVoucherList>> GetProvidersVouchersAsync(int id, int page)
        {
            return await networking.GetProvidersVouchersAsync(id, page);
        }

        public async Task<Order> CreateOrderAsync(Order order)
        {
            //Step 1 - Check if the experiences are in stock
            foreach (var item in order.ShoppingCart.ShoppingCartItems)
            {
                if (!await experienceNet.IsInStockAsync(item.Experience.Id, item.Quantity))
                {
                    throw new Exception("Not in stock!");
                }
            }

            //Step 2 - Create payment call to Stripe
            try
            {
                await CreatePayment(order);
            }
            catch (Exception e)
            {
                throw new Exception("Payment failed");
            }
            
            //Step 3/4 - Remove experiences stock from database, Generate vouchers and save them
            foreach (var item in order.ShoppingCart.ShoppingCartItems)
            {
                await experienceNet.RemoveStockAsync(item.Experience.Id, item.Quantity);
                memoryCache.Remove("CachedExperiences");
                var validity = DateTime.Today.AddMonths(item.Experience.ExperienceValidity).ToString();
                var voucher = new Voucher {ExperienceName = item.Experience.Name, Validity = validity, Img = item.Experience.Picture};
                var vouchers = Enumerable.Repeat(voucher, item.Quantity).ToList();
                var generateVoucher = await GenerateVoucher(vouchers);
                item.Voucher = generateVoucher;
            }

            //Step 5 - Create Order and save it
            var orderAsync = await networking.CreateOrderAsync(order);
            
            //Step 6 - Return successful order
            return orderAsync;
        }

        private async Task<string> GenerateVoucher(IList<Voucher> vouchers)
        {
            var serialize = JsonSerializer.Serialize(vouchers, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
            HttpClient client = new();
            var httpRequestMessage = new HttpRequestMessage(HttpMethod.Post, pdfUri);
            httpRequestMessage.Headers.Authorization = new AuthenticationHeaderValue("Bearer", pdfToken);
            var stringContent = new StringContent(serialize, Encoding.UTF8, "application/json");
            httpRequestMessage.Content = stringContent;
            
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            dynamic jObject = JObject.Parse(readAsStringAsync);
            var url = jObject.response;
            return url;
        }

        private async Task CreatePayment(Order order)
        {
            var paymentIntentService = new PaymentIntentService();
            
            PaymentIntent paymentIntent = null;

            try
            {
                if (order.PaymentId != null)
                {
                    var options = new PaymentIntentCreateOptions
                    {
                        PaymentMethod = order.PaymentId,
                        Amount = Convert.ToInt64(order.ShoppingCart.OrderTotal),
                        Currency = "dkk",
                        ConfirmationMethod = "manual",
                        Confirm =  true
                    };
                    paymentIntent = await paymentIntentService.CreateAsync(options);
                }

                if (paymentIntent?.Status == "requires_action")
                {
                    throw new Exception("Action required");
                }
            }
            catch (StripeException e)
            {
                throw new Exception(e.Message);
            }
        }
    }
}