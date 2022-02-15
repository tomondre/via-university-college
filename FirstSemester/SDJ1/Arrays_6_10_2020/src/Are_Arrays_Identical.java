import java.util.Scanner;
public class Are_Arrays_Identical
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Prva skupina 4 cisel");
    boolean same = true;
    int[] prve = {keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(),
        keyboard.nextInt()};
    System.out.println("Druha skupina 4 cisel");
    int[] druhe = {keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(),
        keyboard.nextInt()};
    for (int i = 0;i< prve.length;i++){
      if (prve[i]!=druhe[i])
      {
        same = false;
        break;
      }
    }
    System.out.println(same);
  }
}