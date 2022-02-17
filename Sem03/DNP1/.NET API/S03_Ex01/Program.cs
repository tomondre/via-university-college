using System;
using System.Collections.Generic;
using System.Text.Json;

namespace S03_Ex01
{
    class Program
    {
        static void Main(string[] args)
        {
            Person p1 = new() {FirstName = "Tomas", LastName = "Ondrejka", Age = 20, Height = 185, IsMarried = false, Sex = 'M', Hobbies = new string[]{"Finance", "WorkingOut"}};
            Person p2 = new() {FirstName = "Peter", LastName = "Petersen", Age = 23, Height = 180, IsMarried = false, Sex = 'M', Hobbies = new string[]{"WorkingOut"}};
            Person p3 = new() {FirstName = "Adele", LastName = "Madelaine", Age = 25, Height = 165, IsMarried = true, Sex = 'F', Hobbies = new string[]{"Running", "EatingHealthy"}};

            List<Person> people = new List<Person>() {p1, p2, p3 };
            string json = JsonSerializer.Serialize(people, new JsonSerializerOptions {WriteIndented = true});
            Console.Write(json);
        }
    }
}