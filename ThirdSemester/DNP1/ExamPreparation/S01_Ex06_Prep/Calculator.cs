using System.Linq;

namespace S01_Ex06_Prep
{
    public class Calculator
    {
        public static int Add(int a, int b)
        {
            return a + b;
        }

        public static int Add(int[] ints)
        {
            int sum = 0;
            for (int i = 0; i < ints.Length; i++)
            {
                sum += ints[i];
            }

            return sum;
        }

        public static int Max(int a, int b)
        {
            int[] ints= {a, b};
            return ints.Max();
        }
    }
}