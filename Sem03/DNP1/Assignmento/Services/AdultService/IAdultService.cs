using System.Collections;
using System.Collections.Generic;
using Person;

namespace FileData
{
    public interface IAdultService
    {
        void AddAdult(Adult adult);
        IList<Adult> GetAllAdults();
        void RemoveAdult(int adultId);
        public void EditAdult(Adult loadedAdult);
        public Adult GetAdultById(int id);
        public int GetAdultsId(Adult adult);

    }
}