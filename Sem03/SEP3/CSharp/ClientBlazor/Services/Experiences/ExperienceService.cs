using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using ClientBlazor.Cache;
using GrpcFileGeneration.Models;

namespace ClientBlazor.Services.Experiences
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

        public async Task<Experience> AddExperienceAsync(Experience experience)
        {
            var httpRequest = await GetHttpRequestAsync(HttpMethod.Post, $"{uri}Experiences");
            var experienceAsJson = JsonSerializer.Serialize(experience);
            var stringContent = new StringContent(experienceAsJson, Encoding.UTF8, "application/json");
            httpRequest.Content = stringContent;
            var httpResponse = await client.SendAsync(httpRequest);

            CheckException(httpResponse);

            var readAsString = await httpResponse.Content.ReadAsStringAsync();
            var deserialize = JsonSerializer.Deserialize<Experience>(readAsString, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
            return deserialize;
        }

        public async Task<Page<ExperienceList>> GetAllProviderExperiencesAsync(int? providerId, int page)
        {
            if (providerId == null)
            {
                var cachedUserAsync = await cacheService.GetCachedUserAsync();
                providerId = cachedUserAsync.Id;
            }

            var httpRequest =
                await GetHttpRequestAsync(HttpMethod.Get, $"{uri}Providers/{providerId}/Experiences?page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequest);

            CheckException(httpResponseMessage);

            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var deserialize = JsonSerializer.Deserialize<Page<ExperienceList>>(readAsStringAsync,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return deserialize;
        }

        public async Task<Page<ExperienceList>> GetAllProviderExperiencesByNameAsync(int? providerId, string name,
            int page)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get,
                $"{uri}Providers/{providerId}/Experiences?name={name}&page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);

            CheckException(httpResponseMessage);

            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var experienceList = JsonSerializer.Deserialize<Page<ExperienceList>>(readAsStringAsync,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return experienceList;
        }

        public async Task DeleteExperienceAsync(Experience experience)
        {
            var httpRequest = await GetHttpRequestAsync(HttpMethod.Delete, $"{uri}Experiences/{experience.Id}");
            var httpResponseMessage = await client.SendAsync(httpRequest);

            CheckException(httpResponseMessage);
        }

        public async Task<Experience> GetExperienceByIdAsync(int id)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}Experiences/{id}");
            var response = await client.SendAsync(httpRequestMessage);
            
            CheckException(response);
            
            var objAsJson = await response.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Experience>(objAsJson, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
        }

        public async Task<Experience> EditExperienceAsync(Experience experience)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Patch, $"{uri}Experiences/{experience.Id}");
            string expAsJson = JsonSerializer.Serialize(experience);
            HttpContent content = new StringContent(expAsJson, Encoding.UTF8,
                "application/json");
            httpRequestMessage.Content = content;
            var response = await client.SendAsync(httpRequestMessage);
            
            CheckException(response);
            
            var objAsJson = await response.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Experience>(objAsJson, new JsonSerializerOptions()
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