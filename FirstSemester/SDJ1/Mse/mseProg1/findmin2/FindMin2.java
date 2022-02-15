package findmin2;

public class FindMin2
{
  public int findMin2(int[] input)
  {
    int temp = input[0];
    for (int i = 0; i < input.length; i++)
    {
      if (input[i] < temp)
      {
        temp = input[i];
      }
    }


    return temp;
  }
}

