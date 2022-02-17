package dectobin;
import java.util.Scanner;
public class DecToBin
{
  public static String decToBinary(int n)

  {

    // We initialise an output as a string
    String binaryNum = "";

    // We throw an exception if there is an illegal input
    if(n<0) throw new IllegalArgumentException();
    while (n!=0){
      if(n%2==0){
        binaryNum += "0";
      }
      else binaryNum += "1";
      n/=2;
    }
    return new StringBuilder(binaryNum).reverse().toString();
  }
  public static void main(String[] args)
  {
    while (true)
    {
      System.out.println("Type input:");
      Scanner in = new Scanner(System.in);
      int read = in.nextInt();
      System.out.println(decToBinary(read));
      System.out.println();
    }
  }
}

