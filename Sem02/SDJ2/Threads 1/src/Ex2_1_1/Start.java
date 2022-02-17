package Ex2_1_1;

public class Start
{
  public static void main(String[] args)
  {


    (new Thread(()->{
      while(true)
      {
        for (int i = 0; i < 10; i++)
        {
          System.out.println(i);
        }
      }
    })).start();

    (new Thread(()->{
      while(true){
        for (int i = 0; i < 10; i++)
        {
          System.out.println((char)(i+97));
        }
      }
    })).start();
//    Thread numPrint = new Thread(new first.Numbers());
//    Thread letPrint = new Thread(new first.Letters());
//
//    numPrint.start();
//    letPrint.start();
  }
}
