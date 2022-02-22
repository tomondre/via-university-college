import java.util.Scanner;

public class DvaD_Array
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Write no of colums: ");
    int b = keyboard.nextInt();
    System.out.println("Write no of rows: ");
    int a = keyboard.nextInt();
    int[][] x = new int[a][b];
    for (int i = 0;i<a;i++){
      for (int p = 0;p<b;p++){
        System.out.println("Write number to position: x: " + p + " y: " + i);
        x[i][p]=keyboard.nextInt();
      }
    }
    for (int i = 0;i<a;i++){
      for (int p = 0;p<b;p++){
        System.out.print(x[i][p]+" ");
      }
      System.out.println();
    }
  }
}
