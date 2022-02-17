import java.util.ArrayList;

public class SquareAndMultiply
{
  public int squareAndMultiply(int base, int exponent, int modulo)
  {
    double result = base;
    ArrayList<Integer> list = new ArrayList<Integer>();

    while (exponent != 0)
    {
      list.add(exponent % 2);
      exponent /= 2;
    }
    for (int i = list.size() - 2; i >= 0; i--)
    {
      if (list.get(i) == 1)
      {
        result = result * result * base;
      }
      else
      {
        result *= result;
      }

      result %= modulo;

    }

    return (int) result;
  }

}
