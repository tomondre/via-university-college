package Ex3_1.observers;

public class Pedestrian implements LightObserver
{
  private String previousLight;
  private int id;

  public Pedestrian(int id)
  {
    this.id = id;
  }

  @Override public void setLight(String currentLight)
  {

    if ("RED".equals(currentLight))
    {
      System.out.println("Pedestrian " + id + " walks");
    }

    else if ("GREEN".equals(currentLight))
    {
      System.out.println("Pedestrian " + id + " stops");
    }

    else if ("YELLOW".equals(currentLight))
    {
      if ("GREEN".equals(previousLight))
      {
        System.out.println("Pedestrian " + id + " runs faster");
      }
    }
    previousLight = currentLight;
  }
}
