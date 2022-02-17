using System;
using System.Text.RegularExpressions;

namespace S02_Ex06
{
    class Program
    {
        static void Main(string[] args)
        {
            string randomString = GetRandomString();
            Console.WriteLine(randomString);
            var findSums = FindSums(randomString);
            foreach (var num in findSums)  
            {
                Console.WriteLine(num);
            }
        }
        
        public static string GetRandomString()
        {
            var strings = new String[3];
            strings[0] = "abcdefghijklmnopqrstuvwxyz";
            strings[1] = "0123456789";
            strings[2] = "?";
            string result = "";

            var ran = new Random();
            while (result.Length < 20)
            {
                var randomNum = ran.Next(strings.Length);
                var randomCharIndex = ran.Next(strings[randomNum].Length);
                result += strings[randomNum][randomCharIndex];
            }

            return result;
        }

        public static int[] FindSums(string input)
        {
            string[] slicedString = input.Split('?');
            for (int i = 0; i < slicedString.Length; i++)
            {
                slicedString[i] = Regex.Replace(slicedString[i], "[A-Za-z]", "0").Replace(" ", "0");
            }
            
            int[] answer = new int[slicedString.Length];
            for (int i = 0; i < answer.Length; i++)
            {
                for (int j = 0; j < slicedString[i].Length; j++)
                {
                    answer[i] += slicedString[i][j] - '0';
                }
            }
            return answer;
        }
    }
}