using System;

namespace Ex11
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(countClumpsCorrect(new int[] {1, 1, 1, 1, 1, 1}));
        }

        private static int countClumps(int[] nums)
        {
            var heighestClump = 0;
            var clumpCount = 0;
            var lastNum = -1;
            foreach (var num in nums)
            {
                if (lastNum == num)
                {
                    clumpCount++;
                }
                else
                {
                    if (heighestClump < clumpCount)
                    {
                        heighestClump = clumpCount;
                    }
                }
                lastNum = num;
            }

            return ++heighestClump;
        }

        private static int countClumpsCorrect(int[] nums)
        {
            var clumpsFound = 0;
            var lastNum = -1;
            var lastClump = -1;
            foreach (var num in nums)
            {
                if (num == lastNum && lastClump != num)
                {
                    clumpsFound++;
                    lastClump = num;
                }
                lastNum = num;
            }
            return clumpsFound;
        }
    }
}