package bintodec;

import java.util.Scanner;

public class BinToDec
{
  public static int binToDecimal(int[] input)
  {
    // We initialise an output as an integer
    int result = 0;
    for (int i = 0; i < input.length; i++)
    {
      if (input[i] == 0){
        result *= 2;
      }
      else {
        result = result * 2 + 1;
      }
    }

    return result;
  }
  public static void main(String[] args)
  {

      while (true)
      {
        System.out.println("Type input:");
        Scanner in = new Scanner(System.in);
        String read = in.nextLine();

        int[] input = new int[read.length()];
        for (int i = 0; i < read.length(); i++)
        {
          input[i] = Integer.parseInt(""+ read.charAt(i));
        }

        System.out.println(binToDecimal(input));
        System.out.println();
      }

  }
}
