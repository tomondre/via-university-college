using System;

namespace Ex8
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write(StringInsertion("word"));
        }

        public static string StringInsertion(string a)
        {
            return $"<<{a}>>";
        }
    }
}