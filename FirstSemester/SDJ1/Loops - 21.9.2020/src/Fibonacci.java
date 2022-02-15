public class Fibonacci
{
  public static void main(String[] args)
  {
  int a = 1;
    int b = 0;
    for (int i = 0;i<=20;i++)
    {
      System.out.println("Fibonacci(" + i + ") = " + (a+b));
        b  = a  + b;
        a = b-a;
    }
  }
}
