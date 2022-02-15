using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using Person;

namespace FileData
{
    public class FileContext : IFileContext
    {
        // public IList<Family> Families { get; private set; }
        public IList<Adult> Adults { get; set; }

        // private readonly string familiesFile = "families.json";
        private readonly string adultsFile = "Data/adults.json";

        public FileContext()
        {
            // Families = File.Exists(familiesFile) ? ReadData<Family>(familiesFile) : new List<Family>();
            Adults = File.Exists(adultsFile) ? ReadData<Adult>(adultsFile) : new List<Adult>();
        }

        private IList<T> ReadData<T>(string s)
        {
            using (var jsonReader = File.OpenText(s))
            {
                return JsonSerializer.Deserialize<List<T>>(jsonReader.ReadToEnd());
            }
        }

        public void SaveChanges()
        {
            // storing families
            // string jsonFamilies = JsonSerializer.Serialize(Families, new JsonSerializerOptions
            // {
            //     WriteIndented = true
            // });
            // using (StreamWriter outputFile = new StreamWriter(familiesFile, false))
            // {
            //     outputFile.Write(jsonFamilies);
            // }

            // storing persons
            string jsonAdults = JsonSerializer.Serialize(Adults, new JsonSerializerOptions
            {
                WriteIndented = true
            });
            using (StreamWriter outputFile = new StreamWriter(adultsFile, false))
            {
                outputFile.Write(jsonAdults);
            }
        }
    }
}