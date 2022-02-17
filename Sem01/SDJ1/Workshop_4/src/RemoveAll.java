import java.util.Scanner;

public class RemoveAll
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Write list of numbers: ");
    double[] list = {keyboard.nextDouble(), keyboard.nextDouble(),
        keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble(),
        keyboard.nextDouble(), keyboard.nextDouble(), keyboard.nextDouble(),
        keyboard.nextDouble(), keyboard.nextDouble()};
    System.out.println("Write occasion: ");
    double occ = keyboard.nextDouble();
    int occurences= 0;

    for (int i = 0;i<list.length;i++){
      if (list[i]==occ){
        occurences++;
      }
    }
    double temp[] = new double[list.length-occurences];
    System.out.println("Number of occurences: " + occurences);
    for (int i = 0;i< list.length;i++){
      if (!(list[i]==occ)){
        for (int x = 0;x< temp.length;x++){
          if (temp[x]==0){
            temp[x]=list[i];
            break;
          }
        }
      }
    }
    for (int i = 0; i< temp.length;i++){
      System.out.println(temp[i]);
    }

  }
}
