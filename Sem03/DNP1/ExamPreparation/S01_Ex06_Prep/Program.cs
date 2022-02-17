using System;

namespace S01_Ex06_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 10;
            int b = 11;
            var max = Calculator.Max(a, b);
            Console.WriteLine(max);
        }
    }
}