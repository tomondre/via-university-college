using System;

namespace Ex5
{
    class Calculator
    {
        public int Add(int a, int b)
        {
            return a + b;
        }

        public int Add(int[] nums)
        {
            int sum = 0;
            foreach (var num in nums)
            {
                sum += num;
            }
            return sum;
        }
    }
}