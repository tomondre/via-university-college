using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using Person;

namespace FileData
{
    public interface IAdultService
    {
        Task<Adult> AddAdultAsync(Adult adult);
        Task<IList<Adult>> GetAllAdultsAsync();
        Task<Adult> RemoveAdultAsync(int adultId);
        public Task<Adult> EditAdultAsync(Adult loadedAdult);
        public Task<Adult> GetAdultByIdAsync(int id);
        public Task<int> GetAdultsIdAsync(Adult adult);
    }
}