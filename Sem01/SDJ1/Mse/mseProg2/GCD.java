public class GCD
{
  public int findGCD(int a, int p)
  {
    int gcd = 1;

    for (int i = 2; i <= a; i++)
    {
      if ((a % i == 0) && (p % i == 0))
      {
        gcd = i;
      }
    }
    return gcd;
  }
}
