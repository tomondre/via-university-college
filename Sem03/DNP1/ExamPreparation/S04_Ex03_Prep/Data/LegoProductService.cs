using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using S04_Ex03_Prep.Models;

namespace S04_Ex03_Prep.Data
{
    public class LegoProductService : ILegoProductService
    {
        private HttpClient client;
        
        public LegoProductService(HttpClient client)
        {
            this.client = client;
        }
        
        public async Task<IList<LegoProduct>> GetAllProductsForTheme(string theme)
        {
            try
            {
                var response = await client.GetAsync($"https://lego-theme-products-scraper.herokuapp.com/themes/{theme}");
                CheckException(response);
                var readAsStringAsync = await response.Content.ReadAsStringAsync();
                var legoProducts = JsonSerializer.Deserialize<IList<LegoProduct>>(readAsStringAsync, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
                return legoProducts;
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }

        private void CheckException(HttpResponseMessage responseMessage)
        {
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception(responseMessage.StatusCode.ToString());
            }   
        }
    }
}