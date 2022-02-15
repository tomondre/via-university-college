public class Company_test
{
  public static void main(String[] args)
  {
    Adress a1 = new Adress("Mik doh",8,"Horsens",8700);
    Adress a2 = new Adress("Nygade",3,"Copenhagen",80);
    Company c1 = new Company("Color","tomas",25,a1);
    Company c2 = new Company("car industry","peter",3,a2);
    System.out.println(c1);
    System.out.println(c2);
  }
}
