using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using ClientBlazor.Cache;
using ClientBlazor.Data.Authentication;
using GrpcFileGeneration.Models;
using Microsoft.AspNetCore.Components.Authorization;
using Provider = ClientBlazor.Models.Provider;
using ProviderList = ClientBlazor.Models.Orders.ProviderList;
using User = ClientBlazor.Models.User;

namespace ClientBlazor.Services.Providers
{
    public class ProviderService : IProviderService
    {
        private HttpClient client;
        private readonly AuthenticationStateProvider authenticationStateProvider;
        private readonly ICacheService cacheService;
        private string uri;

        public ProviderService(HttpClient client, AuthenticationStateProvider authenticationStateProvider,
            ICacheService cacheService)
        {
            this.client = client;
            this.authenticationStateProvider = authenticationStateProvider;
            this.cacheService = cacheService;
            uri = "https://localhost:5001/Provider";
        }

        public async Task CreateProvider(Provider provider)
        {
            provider.SecurityType = "provider";
            string providerAsJson = JsonSerializer.Serialize(provider);
            var stringContent = new StringContent(providerAsJson, Encoding.UTF8, "application/json");
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Post, uri);
            httpRequestMessage.Content = stringContent;
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);

            CheckException(httpResponseMessage);

            var readAsStringAsync = await httpResponseMessage.Content.ReadAsStringAsync();
            var user = JsonSerializer.Deserialize<User>(readAsStringAsync, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
            await ((CurrentAuthenticationStateProvider) authenticationStateProvider).ValidateUser(user);
        }

        public async Task<Page<ProviderList>> GetAllProviders(int page)
        {
            var httpRequest = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}/?approved=true&page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequest);

            CheckException(httpResponseMessage);

            var providersAsJson = await httpResponseMessage.Content.ReadAsStringAsync();
            var providers = JsonSerializer.Deserialize<Page<ProviderList>>(providersAsJson,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return providers;
        }

        public async Task<Provider> GetProviderById(int id)
        {
            var httpRequestMessage = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}/{id}");
            HttpResponseMessage response = await client.SendAsync(httpRequestMessage);

            CheckException(response);

            var objAsJson = await response.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Provider>(objAsJson, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
        }

        public async Task<Provider> EditProvider(Provider provider)
        {
            var httpRequest = await GetHttpRequestAsync(HttpMethod.Patch, $"{uri}/{provider.Id}");
            var json = JsonSerializer.Serialize(provider);
            var stringContent = new StringContent(json, Encoding.UTF8, "application/json");
            httpRequest.Content = stringContent;
            var httpResponseMessage = await client.SendAsync(httpRequest);

            CheckException(httpResponseMessage);

            var objAsJson = await httpResponseMessage.Content.ReadAsStringAsync();
            return JsonSerializer.Deserialize<Provider>(objAsJson, new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
        }

        public async Task DeleteProviderAsync(Provider provider)
        {
            var httpRequest = await GetHttpRequestAsync(HttpMethod.Delete, $"{uri}/{provider.Id}");
            var httpResponseMessage = await client.SendAsync(httpRequest);

            CheckException(httpResponseMessage);
        }

        public async Task<Page<ProviderList>> GetAllNotApprovedProvidersAsync(int page)
        {
            var httpRequest = await GetHttpRequestAsync(HttpMethod.Get, $"{uri}/?approved=false&page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequest);

            CheckException(httpResponseMessage);

            var providersAsJson = await httpResponseMessage.Content.ReadAsStringAsync();
            var providers = JsonSerializer.Deserialize<Page<ProviderList>>(providersAsJson,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return providers;
        }

        public async Task<Page<ProviderList>> GetAllProvidersByNameAsync(string name, int page)
        {
            var httpRequestMessage =
                await GetHttpRequestAsync(HttpMethod.Get, $"{uri}?approved=true&name={name}&page={page}");
            var httpResponseMessage = await client.SendAsync(httpRequestMessage);

            CheckException(httpResponseMessage);

            var providersAsJson = await httpResponseMessage.Content.ReadAsStringAsync();
            var providers = JsonSerializer.Deserialize<Page<ProviderList>>(providersAsJson,
                new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            return providers;
        }

        private async Task<HttpRequestMessage> GetHttpRequestAsync(HttpMethod method, string uri)
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