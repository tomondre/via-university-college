package Ex3_1.observers;

public class SleepyDriver implements LightObserver
{
  private String previousLight;
  private int id;

  public SleepyDriver(int id)
  {
    this.id = id;
  }

  @Override public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
    {
      System.out.println("SleepyDriver " + id + " turns engine on and drives");
    }

    else if ("GREEN".equals(previousLight))
    {

      if ("YELLOW".equals(currentLight))
      {
        System.out.println("SleepyDriver " + id + " slows down");
      }
    }

    else if ("RED".equals(currentLight))
    {
      System.out.println("SleepyDriver " + id + " stops");
    }

    previousLight = currentLight;
    previousLight = currentLight;
  }
}
