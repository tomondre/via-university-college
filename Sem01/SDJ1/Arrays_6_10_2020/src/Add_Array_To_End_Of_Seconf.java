public class Add_Array_To_End_Of_Seconf {
  public static void main(String[] args)
  {
    int[] numbers={1,2,3};
    int[] dvojnasobok={0,0,0,0,0,0};
    for (int i = numbers.length;i< dvojnasobok.length;i++)
    {
      dvojnasobok[i] = numbers[i-numbers.length];
    }
   for (int i = 0;i< dvojnasobok.length;i++)
   {
     System.out.println(dvojnasobok[i]);
   }
  }
}
