public class Age
{
  public static void main(String[] args)
  {
    int age = 15;
    if (age < 0)
    {
      System.out.println("Error in value");
    }
    if (age >=0 && age <= 12 )
    {
      System.out.println("Child");
    }
    if (age >=13 && age <= 19)
    {
      System.out.println("Teenager");
    }
    if (age >=20 && age <= 65)
    {
      System.out.println("Adult");
    }
    if (age > 65)
    {
      System.out.println("Senior citizen");
    }
  }
}

