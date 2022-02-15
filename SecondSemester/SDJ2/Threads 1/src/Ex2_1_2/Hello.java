package Ex2_1_2;

public class Hello implements Runnable
{
  private int num;
  public Hello(int num)
  {
    this.num = num;
  }
  @Override
  public void run(){
    while (true){
      for (int i = 0; i < num; i++)
      {
        System.out.println("hello");
      }
    }
  }
}
