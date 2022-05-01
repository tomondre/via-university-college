using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Person;

namespace FileData
{
    public class AdultApiService : IAdultApiService
    {
        private HttpClient client;
        private string uri;

        public AdultApiService()
        {
            uri = "https://localhost:5001/Adults";
            client = new HttpClient();
        }

        public async Task AddAdultAsync(Adult adult)
        {
            string adultAsJson = JsonSerializer.Serialize(adult);
            HttpContent content = new StringContent(adultAsJson, Encoding.UTF8, "application/json");
            var httpResponseMessage = await client.PostAsync(uri, content);
            CheckException(httpResponseMessage);
        }

        public async Task<IList<Adult>> GetAllAdultsAsync()
        {
            HttpResponseMessage reponse = await client.GetAsync(uri);
            CheckException(reponse);
            string message = await reponse.Content.ReadAsStringAsync();
            List<Adult> result = JsonSerializer.Deserialize<List<Adult>>(message, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
            return result;
        }

        public async Task RemoveAdultAsync(int adultId)
        {
            HttpResponseMessage deleteAsync = await client.DeleteAsync(uri + $"/{adultId}");
            CheckException(deleteAsync);
        }

        public async Task EditAdultAsync(Adult loadedAdult)
        {
            string serialize = JsonSerializer.Serialize(loadedAdult);
            HttpContent content = new StringContent(serialize, Encoding.UTF8, "application/json");
            HttpResponseMessage httpResponseMessage = await client.PutAsync(uri, content);
            CheckException(httpResponseMessage);
        }

        public async Task<Adult> GetAdultByIdAsync(int id)
        {
            HttpResponseMessage response = await client.GetAsync(uri + $"/{id}");
            CheckException(response);
            string responseAsJson = await response.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Adult>(responseAsJson, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
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