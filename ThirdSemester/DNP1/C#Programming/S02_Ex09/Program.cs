using System;

namespace S02_Ex09
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(NumToWord(1315));
        }

        public static string NumToWord(int num)
        {
            string[][] numberWordsToTen = new string[4][];
            numberWordsToTen[0] = new[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            numberWordsToTen[1] = new []{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "eighty", "ninety"};
            string hd = "hundred";
            numberWordsToTen[2] = new[] {" " + hd , numberWordsToTen[0][1] + " " + hd ,numberWordsToTen[0][2] + " " + hd ,numberWordsToTen[0][3] + " " + hd ,numberWordsToTen[0][4] + " " + hd ,numberWordsToTen[0][5] + " " + hd ,numberWordsToTen[0][6] + " " + hd ,numberWordsToTen[0][7] + " " + hd ,numberWordsToTen[0][8] + " " + hd ,numberWordsToTen[0][9] + " " + hd };
            string thd  = "thousand";
            numberWordsToTen[3] = new[] {" " + thd , numberWordsToTen[0][1] + " " + thd ,numberWordsToTen[0][2] + " " + thd ,numberWordsToTen[0][3] + " " + thd ,numberWordsToTen[0][4] + " " + thd ,numberWordsToTen[0][5] + " " + thd ,numberWordsToTen[0][6] + " " + thd ,numberWordsToTen[0][7] + " " + thd ,numberWordsToTen[0][8] + " " + thd ,numberWordsToTen[0][9] + " " + thd };
            string result = "";
            
            for (int i = 0; i < num.ToString().Length; i++)
            {
                var preparedDigit = getDigit(num, i);
                Console.WriteLine(preparedDigit);

                result = numberWordsToTen[i][preparedDigit] + " " +  result;
            }
            return result;
        }

        public static int getDigit(int fromNum, int digitIndex)
        {
            
            return(int)((fromNum / Math.Pow(10, digitIndex)) % 10);;
        }
    }
}