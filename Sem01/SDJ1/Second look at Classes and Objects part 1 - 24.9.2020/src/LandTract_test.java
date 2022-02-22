import java.util.Scanner;
public class LandTract_test
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Write width of first Land");
    int w1 = keyboard.nextInt();
    System.out.println("Write length of first Land");
    int l1 = keyboard.nextInt();
    LandTract land1 = new LandTract(w1,l1);

    System.out.println("Write width of second Land");
    int w2 = keyboard.nextInt();
    System.out.println("Write length of second Land");
    int l2 = keyboard.nextInt();

    LandTract land2 = new LandTract(w2,l2);
    System.out.println(land1.equals(land2));

  }
}
