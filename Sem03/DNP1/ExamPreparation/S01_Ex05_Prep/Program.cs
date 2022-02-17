using System;

namespace S01_Ex05_Prep
{
    class Program
    {
        static void Main(string[] args)
        {
            //A
            Console.WriteLine("A");
            int a = 1;
            int b = 2;
            var add = Calculator.Add(a, b);
            Console.WriteLine(add);
            
            //B
            Console.WriteLine("B");
            int[] ints = new[] {1, 2, 3, 4, 5};
            var sum = Calculator.Add(ints);
            Console.WriteLine(sum);
        }
    }
}