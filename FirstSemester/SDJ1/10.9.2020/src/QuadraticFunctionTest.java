public class QuadraticFunctionTest
{
  public static void main(String[] args)
  {
    QuadraticFunction q1 = new QuadraticFunction(1,2,2);
    QuadraticFunction q2 = new QuadraticFunction(2,-4,2);
    QuadraticFunction q3 = new QuadraticFunction(2,5,2);
    System.out.println(q1.getRoots());
    System.out.println(q2.getRoots());
    System.out.println(q3.getRoots());
  }



}
