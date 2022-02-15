using System;
using System.Collections;

namespace Ex5
{
    public class Run
    {
        public static void Main(string[] args)
        {
            var Calculator = new Calculator();
            var nums = new ArrayList();
            var reading = "";
            while (true)
            {
                reading = Console.ReadLine();
                if (reading == "exit")
                {
                    break;
                }
                nums.Add(Int32.Parse(reading));
            }
            Console.Write(Calculator.Add(nums.ToArray(typeof(int)) as int[]));
        }
    }
}