using System;

namespace Ex3
{
    class Person
    {
        public string Name { get; set; }

        public Person(string name)
        {
            this.Name = name;
        }

        public void Introduce()
        {
            Console.Write($"Hi, my name is: {Name} ");
        }
    }
}