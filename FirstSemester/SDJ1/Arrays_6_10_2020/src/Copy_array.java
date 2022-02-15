public class Copy_array
{
  public static void main(String[] args)
{
  int[] cisla = {1, 2, 3, 4};
  int[] copy = new int[cisla.length];
  for(int i = 0; i< cisla.length;i++)
  {
    copy[i] = cisla[i];
  }
  for (int i = 0;i<copy.length;i++){
    System.out.println(copy[i]);
  }
}
}
