public class Double_array
{
  public static void main(String[] args){
    int[] numbers ={2,4,6,8,10,12};
    for (int i=0;i< numbers.length;i++){
      numbers[i]*=2;
    }
    for (int i=0;i< numbers.length;i++){
      System.out.println(numbers[i]);
    }
  }
}
