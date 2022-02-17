using System;

namespace Ex5
{
    public class Run
    {
        public static void Main(string[] args)
        {
            var Calculator = new Calculator();
            Console.Write(Calculator.Add(1, 2) + "\n");
            Console.Write(Calculator.Add(new int[] {1, 2, 3, 4, 5}));
        }
    }
}