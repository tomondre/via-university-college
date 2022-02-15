using System;

namespace Ex7
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write(StringWrapperABBA("Hi", "Bye"));
        }

        public static String StringWrapperABBA(string a, string b)
        {
            return $"{a}{b}{b}{a}";
        }
    }
}