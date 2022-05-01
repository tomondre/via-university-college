using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components;
using Person;

namespace FileData
{
    public class AdultService : IAdultService
    {
        private IFileContext fileContext;

        public AdultService(IFileContext fileContext)
        {
            this.fileContext = fileContext;
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
                var fileContextAdults = fileContext.Adults;
                int max = fileContextAdults.Max(person => person.Id);
                adult.Id = ++max;
                fileContextAdults.Add(adult);
                fileContext.SaveChanges();
                return adult;
            }
        }

        private Adult FindAdult(Adult adult)
        {
            return fileContext.Adults.First(a =>
                adult.FirstName == a.FirstName &&
                adult.LastName == a.LastName &&
                adult.Sex == a.Sex &&
                adult.HairColor == a.HairColor &&
                adult.Age == a.Age &&
                adult.Height == a.Height);
        }

        public async Task<IList<Adult>> GetAllAdultsAsync()
        {
            return fileContext.Adults;
        }

        public async Task<Adult> RemoveAdultAsync(int adultID)
        {
            Adult adult = fileContext.Adults.First(adult => adult.Id == adultID);
            fileContext.Adults.Remove(adult);
            fileContext.SaveChanges();
            return adult;
        }

        public async Task<Adult> GetAdultByIdAsync(int id)
        {
            return fileContext.Adults.First(adult => adult.Id == id);
        }

        public async Task<int> GetAdultsIdAsync(Adult adult)
        {
            return FindAdult(adult).Id;
        }

        public async Task<Adult> EditAdultAsync(Adult loadedAdult)
        {
            Adult adult = fileContext.Adults.First(adult => adult.Id == loadedAdult.Id);
            adult.JobTitle = loadedAdult.JobTitle;
            adult.Age = loadedAdult.Age;
            adult.Height = loadedAdult.Height;
            adult.Sex = loadedAdult.Sex;
            adult.EyeColor = loadedAdult.EyeColor;
            adult.FirstName = loadedAdult.FirstName;
            adult.LastName = loadedAdult.LastName;
            adult.Weight = loadedAdult.Weight;
            adult.HairColor = loadedAdult.HairColor;
            fileContext.SaveChanges();
            return adult;
        }
    }
}