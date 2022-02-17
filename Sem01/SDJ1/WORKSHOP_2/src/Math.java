public class Math
{
  public static final double PI = 3.1415926;

  private Math()
  {
  }

  public static int max(int a, int b)
  {
    return ((a > b) ? a : b);
  }

  public static double max(double a, double b)
  {
    return ((a > b) ? a : b);
  }

  public static int min(int a, int b)
  {
    return ((a < b) ? a : b);
  }

  public static double man(double a, double b)
  {
    return ((a < b) ? a : b);
  }

  public static int factorial(int n)
  {
    int x = 0;
    for (; n > 0; n--)
    {
      x = x + n;
      System.out.println(n);
    }
    return x;
  }
  public static int pow(int a, int n){
    return a*n;
  }
  public static double pow(double a, int n){
    return a*n;
  }
  public static int sqr(int a){
    return a*a;
  }
  public static double sqr(double a){
    return a*a;
  }
  public static void main(String[] args)
  {
    System.out.println(factorial(10));
  }
}
