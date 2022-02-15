import java.util.Scanner;
public class Pasword
{
  public static void main(String[] args)
  {
    boolean x=true;
    String username,password,confirmation;
    Scanner keyboard = new Scanner(System.in);
    while (x)
    {
      System.out.println("Type username");
      username = keyboard.nextLine();
      System.out.println("Type password");
      password = keyboard.nextLine();
      System.out.println("Type confirmation password");
      confirmation = keyboard.nextLine();
if (password.equals(confirmation))
{
   x = false;
}
else System.out.println("Password and confirmation password does not match");
    }
  }
}
