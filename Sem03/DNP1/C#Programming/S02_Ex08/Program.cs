using System;

namespace S02_Ex08
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write(Largest(new int[]{6, 3, 5, 9, 1, 2}, 3));
        }

        public static int Largest(int[] ints, int k)
        {
            if (ints.Length < k)
            {
                throw new Exception("Nonono");
            }

            Array.Sort(ints, (i1, i2) => i1 < i2 ? -1 : 1);
            return ints[^k];
        }
    }
}