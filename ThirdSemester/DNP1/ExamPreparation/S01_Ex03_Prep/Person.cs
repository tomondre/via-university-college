using System;

namespace S01_Ex03
{
    public class Person
    {
        public string Name { get; set; }


        public void Introduce()
        {
            Console.WriteLine($"Hi, my name is {Name}");
        }
    }
}