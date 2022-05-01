using System;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Person;

namespace FileData
{
    public class UserApiService : IUserApiService
    {
        private HttpClient client;
        private string uri;

        public UserApiService()
        {
            client = new HttpClient();
            uri = "https://localhost:5001/Users";
        }
        
        public async Task<User> ValidateUserAsync(string userName, string password)
        {
            User user = new() {UserName = userName, Password = password};
            string userAsJson = JsonSerializer.Serialize(user);
            HttpContent content = new StringContent(userAsJson, Encoding.UTF8, "application/json");
            HttpResponseMessage httpResponseMessage = await client.PostAsync(uri, content);
            CheckException(httpResponseMessage);
            string fullUserAsJson = await httpResponseMessage.Content.ReadAsStringAsync();
            var us =  JsonSerializer.Deserialize<User>(fullUserAsJson,  new JsonSerializerOptions()
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
            return us;
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