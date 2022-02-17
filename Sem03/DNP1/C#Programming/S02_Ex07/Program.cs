using System;

namespace S02_Ex07
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write(IsPalindrome("do geese see god"));
        }

        public static bool IsPalindrome(string palindrome)
        {
            palindrome = palindrome.Replace(" ", "");
            for (int i = 0; i < palindrome.Length / 2; i++)
            {
                if (palindrome[i] != palindrome[palindrome.Length - 1 - i])
                {
                    return false;
                }
            }

            return true;
        }
    }
}