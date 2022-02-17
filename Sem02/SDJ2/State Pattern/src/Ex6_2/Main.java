package Ex6_2;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Radiator radiator = new Radiator();
    System.out.println(radiator.getPower());

    radiator.turnUp();
    System.out.println(radiator.getPower());

    radiator.turnUp();
    System.out.println(radiator.getPower());

    radiator.turnUp();
    System.out.println(radiator.getPower());

    radiator.turnUp();
    System.out.println(radiator.getPower());
    Thread.sleep(11000);
    System.out.println(radiator.getPower());
  }
}
