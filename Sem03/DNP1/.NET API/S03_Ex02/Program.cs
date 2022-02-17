using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.Json;
using S03_Ex01;

namespace S03_Ex02
{
    class Program
    {
        static void Main(string[] args)
        {
            Person p1 = new() {FirstName = "Tomas", LastName = "Ondrejka", Age = 20, Height = 185, IsMarried = false, Sex = 'M', Hobbies = new string[]{"Finance", "WorkingOut"}};
            Person p2 = new() {FirstName = "Peter", LastName = "Petersen", Age = 23, Height = 180, IsMarried = false, Sex = 'M', Hobbies = new string[]{"WorkingOut"}};
            Person p3 = new() {FirstName = "Adele", LastName = "Madelaine", Age = 25, Height = 165, IsMarried = true, Sex = 'F', Hobbies = new string[]{"Running", "EatingHealthy"}};

            List<Person> people = new List<Person>() {p1, p2, p3 };
            
            StoreObjects(people);

            var readFile = ReadFile();
            Console.Write(readFile);
        }

        public static void StoreObjects(List<Person> people)
        {
            using StreamWriter sw = new StreamWriter("StoredObjects.txt");
            string json = JsonSerializer.Serialize(people, new JsonSerializerOptions {WriteIndented = true});
            sw.Write(json);            
        }

        public static string ReadFile()
        {
            StringBuilder sb = new StringBuilder();
            using StreamReader sr = new StreamReader("StoredObjects.txt");
            string line;
            while ((line = sr.ReadLine()) != null)
            {
                sb.AppendLine(line);
            }

            return sb.ToString();
        }
    }
}