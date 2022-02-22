import java.util.Scanner;
public class Temperature_test
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Write temperature");
    int a = keyboard.nextInt();
    Temperature temp = new Temperature(a);
    System.out.println(temp);
    System.out.println("Celsius: ");
    System.out.println(temp.getCelsius());
System.out.println("Kelvin: ");
System.out.println(temp.getKelvin());
  }
}
