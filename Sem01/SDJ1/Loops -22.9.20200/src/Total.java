public class Total
{
  public static void main(String[] args)
  {
    double sum=0;
    double x = 30;
    for (double i = 1;i <=30;i++)
    {
      sum = sum+(i/x);
System.out.println(sum);

      x--;
    }
    System.out.println(sum);
  }
}