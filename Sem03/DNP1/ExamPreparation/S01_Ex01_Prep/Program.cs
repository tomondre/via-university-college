using System;

namespace S01_Ex01
{
    class Program
    {
        static void Main(string[] args)
        {
            string name;
            
            //Step 1
            Console.WriteLine("Step 1");
            Console.WriteLine("Hello World!");
            
            //Step 2
            Console.WriteLine("Step 2");
            Console.WriteLine("Hello Tomas");
            
            //Step 3
            Console.WriteLine("Step 3");
            name = "Tomas";
            Console.WriteLine("Hello " + name + "!");
            
            //Step 4
            Console.WriteLine("Step 4");
            name = "Tomas";
            Console.WriteLine($"Hello {name}!");
            
            //Step 5
            Console.WriteLine("Step 5");
            name = "Tomas";
            Console.WriteLine($"Hello {name.ToUpper()}!");

            //Step 6
            Console.WriteLine("Step 6");
            var names = new[] {"Tomas", "Peter", "Michael" };
            foreach (var n in names)
            {
                Console.WriteLine($"Hello {n.ToUpper()}!");
            }
        }
    }
}