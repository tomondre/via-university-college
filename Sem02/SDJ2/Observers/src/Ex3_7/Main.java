package Ex3_7;

public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    DataModel model = new DataModel();

    while (true)
    {
      model.recalculateData();

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
      }
    }
  }
}
