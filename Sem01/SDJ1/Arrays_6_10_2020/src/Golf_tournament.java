import java.util.Scanner;
public class Golf_tournament
{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    int[] hits = new int[9];
    int h1=0;
    int sum = 0;

    for (int i=0;i<9;i++){
     System.out.println("Hit number " + (i+1) +": ");
     hits[i] = keyboard.nextInt();
   }
    for (int i = 0; i< hits.length;i++){
      if (hits[i]==1){
        h1++;
      }
    }
    for (int i = 0;i< hits.length;i++){
      sum += hits[i];
    }
    /*
    for (int i = 0;i< hits.length;i++){
      System.out.println(hits[i]);
    }

     */

    System.out.println("Hole in ones: " + h1);
    System.out.println("Avarage is: " + (double)sum/ hits.length);
  }
}
