package Ex3_1.observers;

public class Car implements LightObserver {
  private String previousLight;
  private int id;

  public Car(int id) {
    this.id = id;
  }
  @Override
  public void setLight(String currentLight) {
    if("GREEN".equals(currentLight)) {
      System.out.println("Car " + id + " drives");
    } else if("YELLOW".equals(currentLight)) {
      if("RED".equals(previousLight)) {
        System.out.println("Car " + id + " turns engine on");
      } else {
        System.out.println("Car " + id + " slows down");
      }
    } else if("RED".equals(currentLight)) {
      System.out.println("Car " + id + " stops");
    }
    previousLight = currentLight;
  }

}
