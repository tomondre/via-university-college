using System;
using System.Collections.Generic;
using System.Linq;
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

        public void AddAdult(Adult adult)
        {
            try
            {
                FindAdult(adult);
            }
            catch (Exception e)
            {
                var fileContextAdults = fileContext.Adults;
                int max = fileContextAdults.Max(person => person.Id);
                adult.Id = ++max;
                fileContextAdults.Add(adult);
                fileContext.SaveChanges();
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

        public IList<Adult> GetAllAdults()
        {
            return fileContext.Adults;
        }

        public void RemoveAdult(int adultID)
        {
            Adult adult = fileContext.Adults.First(adult => adult.Id == adultID);
            fileContext.Adults.Remove(adult);
            fileContext.SaveChanges();
        }

        public Adult GetAdultById(int id)
        {
            return fileContext.Adults.First(adult => adult.Id == id);
        }

        public int GetAdultsId(Adult adult)
        {
            return FindAdult(adult).Id;
        }

        public void EditAdult(Adult loadedAdult)
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
        }
    }
}