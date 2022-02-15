package findmax2;

public class FindMax2
{
  public int findMax2(int[] input)
  {
    int temp = input[0];
    for (int i = 0; input.length > i; i++)
    {
      if (input[i] > temp)
      {
        temp = input[i];
      }
    }

    return temp;
  }
}
