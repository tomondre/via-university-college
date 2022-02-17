using System;

namespace Ex9
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write(StringReducer("Chocolate", 1));
        }

        public static string StringReducer(string stringToReduce, int num)
        {
            return stringToReduce.Substring(0, num) + stringToReduce.Substring(stringToReduce.Length - num);
        }
    }
}