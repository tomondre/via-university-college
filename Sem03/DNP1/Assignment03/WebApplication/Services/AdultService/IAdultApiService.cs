using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using Person;

namespace FileData
{
    public interface IAdultApiService
    {
        Task AddAdultAsync(Adult adult);
        Task<IList<Adult>> GetAllAdultsAsync();
        Task RemoveAdultAsync(int adultId);
        public Task EditAdultAsync(Adult loadedAdult);
        public Task<Adult> GetAdultByIdAsync(int id);
    }
}