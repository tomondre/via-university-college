using System;

namespace Ex4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("A: \n");
            PrintEvenNumbers(10);
            
            Console.Write("B: \n");
            PrintOddNumbers(10);
            
            Console.Write("C: \n");
            PrintNumberDivisibleBy(10, 3);
        }
        
        public static void PrintEvenNumbers(int max)
        {
            var num = 0;
            while (num <= max)
            {
                Console.Write(num + "\n");
                num += 2;
            }
        }
        
        public static void PrintOddNumbers(int max)
        {
            var num = 1;
            while (num <= max)
            {
                Console.Write(num + "\n");
                num += 2;
            }
        }

        public static void PrintNumberDivisibleBy(int max, int divisor)
        {
            var num = 0;
            while (num <= max)
            {
                Console.Write(num + "\n");
                num += divisor;
            }
        }
    }
}