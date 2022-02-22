public class Payment
{
  public static void main(String[] args)
  {
    double grains = 2;
    double total = 0;

    for (double i=2;i<64;i++)
    {
      grains = grains*2;
      total = total + grains;
     System.out.println("Number of grains on one field: " + (grains-2) + " Number of grains together: " + total+i);
    }
  }
}
