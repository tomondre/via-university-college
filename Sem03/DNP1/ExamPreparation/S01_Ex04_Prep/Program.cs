using System;

namespace S01_Ex04_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            //A
            Console.WriteLine("A");
            Console.WriteLine("Project created");
            
            //B
            Console.WriteLine("B");
            Numbers.PrintEven(10);
            
            //C
            Console.WriteLine("C");
            Numbers.PrintOdd(10);
            
            //D
            Console.WriteLine("D");
            Numbers.PrintDivisible(3, 10);
        }
    }
}