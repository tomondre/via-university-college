using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components;
using Microsoft.EntityFrameworkCore;
using Person;

namespace FileData
{
    public class AdultRepo : IAdultRepo
    {

        public AdultRepo()
        {
        }

        public async Task<Adult> AddAdultAsync(Adult adult)
        {
            try
            {
                FindAdult(adult);
                return null;
            }
            catch (Exception e)
            {
                 using AdultContext adultDao = new AdultContext();
                 await adultDao.Adults.AddAsync(adult);
                 await adultDao.SaveChangesAsync();
                
                 return FindAdult(adult);
            }
        }

        private Adult FindAdult(Adult adult)
        {
            using AdultContext adultDao = new AdultContext();
            return adultDao.Adults.First(a => a.Id == adult.Id);
        }

        public async Task<IList<Adult>> GetAllAdultsAsync()
        {
            using AdultContext adultDao = new AdultContext();
            return adultDao.Adults.Include(a => a.JobTitle).ToList();
        }
        
        public async Task<Adult> RemoveAdultAsync(int adultID)
        {
            using AdultContext adultDao = new AdultContext();
            var first = adultDao.Adults.Include(a => a.JobTitle).First(a => a.Id == adultID);
            adultDao.Adults.Remove(first);
            adultDao.SaveChanges();
            return first;
        }
        
        public async Task<Adult> GetAdultByIdAsync(int id)
        {
            using AdultContext adultDao = new AdultContext();
            return adultDao.Adults.Include(a => a.JobTitle).First(a => a.Id == id);
        }
        
        public async Task<int> GetAdultsIdAsync(Adult adult)
        {
            using AdultContext adultDao = new AdultContext();
            return adultDao.Adults.First(a => a.FirstName == adult.FirstName && 
                                                  a.LastName == adult.LastName && 
                                                  a.HairColor == adult.HairColor).Id;
        }
        
        public async Task<Adult> EditAdultAsync(Adult loadedAdult)
        {
            using AdultContext adultDao = new AdultContext();
            adultDao.Adults.Update(loadedAdult);
            adultDao.SaveChanges();
            return loadedAdult;
        }
    }
}