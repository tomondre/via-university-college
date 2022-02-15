using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.Json;
using System.Threading.Tasks;
using WebShop.Cache;
using WebShop.Models;

namespace WebShop.Services.Experiences
{
    public class ExperienceService : IExperienceService
    {
        private readonly ICacheService cacheService;
        private HttpClient client;
        private string uri;

        public ExperienceService(ICacheService cacheService)
        {
            this.cacheService = cacheService;
            client = new HttpClient();
            uri = "https://localhost:5001/";
        }

        public async Task<Page<ExperienceList>> GetAllExperiencesAsync(int page)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}experiences?page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var deserialize = JsonSerializer.Deserialize<Page<ExperienceList>>(readAsStringAsync,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return deserialize;
        }

        public async Task<Experience> GetExperienceById(int id)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}experiences/{id}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var deserialize = JsonSerializer.Deserialize<Experience>(readAsStringAsync,
                new JsonSerializerOptions() {PropertyNamingPolicy = JsonNamingPolicy.CamelCase});
            return deserialize;
        }

        public async Task<Page<ExperienceList>> GetExperiencesByCategoryAsync(int id, int page)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}categories/{id}/experiences?page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Page<ExperienceList>>(readAsStringAsync, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
        }

        public async Task<ExperienceList> GetTopExperiences()
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}experiences?top=true");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var experienceList = JsonSerializer.Deserialize<Page<ExperienceList>>(readAsStringAsync, new JsonSerializerOptions(){PropertyNamingPolicy = JsonNamingPolicy.CamelCase});
            return experienceList.Content;
        }

        public async Task<Page<ExperienceList>> GetSortedExperiences(string name, double price, int page)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}experiences/?name={name}&price={price}&page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);
            
            CheckException(httpResponseMessage);
            
            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Page<ExperienceList>>(readAsStringAsync, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
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