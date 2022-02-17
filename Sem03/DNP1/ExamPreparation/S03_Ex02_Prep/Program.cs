using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;

namespace S03_Ex02_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            var generatePeople = GeneratePeople(10);
            var serialize = JsonSerializer.Serialize(generatePeople);
            File.WriteAllText("File.txt" ,serialize);
            Console.WriteLine("Task failed successfully");
        }

        static List<Person> GeneratePeople(int numberOfPeople)
        {
            var firstNames = new string[] {"Tomas", "Peter", "Marek"};
            var lastNames = new string[] {"Petersen", "Tomasen", "Mareksen"};
            var ages = new int[] {20, 30, 40};
            var heights = new double[] {160, 170, 180 };
            var marriageStatus = new bool[] {true, false};
            var hobbies = new string[] {"Running", "Travelling", "Painting"};

            var random = new Random();

            var randomFirstNameIndex = random.Next(0, firstNames.Length);
            var randomLastNameIndex = random.Next(0, lastNames.Length);
            var randomAgeIndex = random.Next(0, ages.Length);
            var randomHeightIndex = random.Next(0, heights.Length);
            var randomMarriageStatusIndex = random.Next(0, marriageStatus.Length);
            var randomHobbiesIndex = random.Next(0, hobbies.Length);

            var people = new List<Person>();
            for (int i = 0; i < numberOfPeople; i++)
            {
                var personToAdd = new Person()
                {
                    FirstName = firstNames[randomFirstNameIndex],
                    LastName = lastNames[randomLastNameIndex],
                    Age = ages[randomAgeIndex],
                    Height = heights[randomHeightIndex],
                    IsMarried = marriageStatus[randomMarriageStatusIndex],
                    Hobbies = new string[] {hobbies[randomHobbiesIndex]}
                };
                people.Add(personToAdd);
            }

            return people;
        }
    }
}