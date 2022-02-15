using System;

namespace S01_Ex04_Prep
{
    public class Numbers
    {
        public static void PrintEven(int max)
        {
            for (int i = 1; i < max; i++)
            {
                if (i % 2 == 0)
                {
                    Console.WriteLine(i);
                }
            }
        }

        public static void PrintOdd(int max)
        {
            for (int i = 1; i < max; i++)
            {
                if (i % 2 == 1)
                {
                    Console.WriteLine(i);
                }
            }
        }

        public static void PrintDivisible(int y, int max)
        {
            for (int i = 0; i < max; i++)
            {
                if (i % y == 0)
                {
                    Console.WriteLine(i);
                }
            }
        }
    }
}