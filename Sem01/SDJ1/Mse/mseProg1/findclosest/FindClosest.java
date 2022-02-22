package findclosest;

public class FindClosest
{
  public int findClosest(int[] input) {
    int temp = 100;
    for (int i = 0; i<input.length;i++){
      for (int j = 0; j < input.length ; j++)
      {
       if (Math.abs(input[i] - input[j])<temp&&i!=j){
         temp = Math.abs(input[i] - input[j]);
      }
      }
    }

return temp;
  }
}