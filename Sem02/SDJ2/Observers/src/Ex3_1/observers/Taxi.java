package Ex3_1.observers;

public class Taxi implements LightObserver
{
  private int id;

  public Taxi(int id)
  {
    this.id = id;
  }

  @Override public void setLight(String currentLight)
  {
    if ("RED".equals(currentLight))
    {
      System.out.println("Taxi " + id + " stops");
    }
    else if ("GREEN".equals(currentLight))
    {
      System.out.println("Taxi " + id + " drives");
    }
  }

}
