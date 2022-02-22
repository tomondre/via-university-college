import java.util.Scanner;
public class Sort
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int x, y, z;
    System.out.println("First number");
    x = keyboard.nextInt();
    System.out.println("Second number");
    y = keyboard.nextInt();
    if (x > y)
    {
      System.out.println(y);
    }
    else if (x == y)
    {
      System.out.println("Same number");
    }
    else
    {
      System.out.println(x);
    }
    System.out.println("Third number");
    z = keyboard.nextInt();


    if (x>y && y >z && x<z)
    {
      System.out.println(y);
      System.out.println(z);
      System.out.println(x);
    }

    if (x<y && y >z && x<z)
    {
      System.out.println(x);
      System.out.println(z);
      System.out.println(y);
    }

    if (x>y && y >z && x<z)
    {
      System.out.println(y);
      System.out.println(x);
      System.out.println(z);
    }
    /*if (x > y)
    {
      if (z > x)
      {
        System.out.println(y);
        System.out.println(x);
        System.out.println(z);
      }
      else
      {
        System.out.println(y);
        System.out.println(z);
        System.out.println(x);
      }

    }
    else if (y>x)
      {
        if (z>y)
        {
          System.out.println(x);
          System.out.println(y);
          System.out.println(z);

        }
        else
        {
          System.out.println(x);
          System.out.println(z);
          System.out.println(y);
        }
      }
    else if (y>z){
      if (x > y)
      {
        System.out.println(z);
        System.out.println(y);
        System.out.println(x);
      }
      else
      {
        System.out.println(z);
        System.out.println(x);
        System.out.println(y);
      }

    }*/

    }

}


