using System;
using System.Linq;

namespace Ex10
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(IntegerDifference(new []{ 10, 3, 5, 6}));
        }

        private static int IntegerDifference(int[] nums)
        {
            return nums.Max() - nums.Min();
        }
    }
}