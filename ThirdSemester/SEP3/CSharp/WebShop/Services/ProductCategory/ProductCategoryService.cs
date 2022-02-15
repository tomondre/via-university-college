using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.Json;
using System.Threading.Tasks;
using WebShop.Cache;
using WebShop.Models;

namespace WebShop.Services.ProductCategory
{
    public class ProductCategoryService : IProductCategoryService
    {
        private HttpClient client;
        private readonly ICacheService cacheService;
        private string uri;

        public ProductCategoryService(HttpClient client, ICacheService cacheService)
        {
            this.client = client;
            this.cacheService = cacheService;
            uri = "https://localhost:5001/ProductCategory";
        }

        public async Task<CategoryList> GetAllCategoriesAsync()
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}?page=0");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var categories = JsonSerializer.Deserialize<Page<CategoryList>>(readAsStringAsync, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
            return categories.Content;
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