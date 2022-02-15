import java.util.Scanner;

public class PythagoreanTheorem
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    Integer[] triangle = new Integer[keyboard.nextInt()];
    int temp;
    for (int i = 0; i < triangle.length; i++)
    {
      triangle[0] = keyboard.nextInt();
      triangle[1] = keyboard.nextInt();
      triangle[2] = keyboard.nextInt();
      if (triangle[1] > triangle[0] && triangle[1] > triangle[2])
      {
        temp = triangle[0];
        triangle[0] = triangle[1];
        triangle[1] = temp;
      }
      if (triangle[2] > triangle[0] && triangle[2] > triangle[1])
      {
        temp = triangle[0];
        triangle[0] = triangle[2];
        triangle[2] = temp;
      }
      triangle[0] *= triangle[0];
      double v = (triangle[1] * triangle[1]) + (triangle[2] * triangle[2]);
      if (triangle[0] == v)
      {
        System.out.println("R ");
      }
      if (triangle[0] > v)
      {
        System.out.println("O ");
      }
      if (triangle[0] < v)
      {
        System.out.println("A ");
      }
    }

  }
}