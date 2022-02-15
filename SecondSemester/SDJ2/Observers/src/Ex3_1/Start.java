package Ex3_1;

import Ex3_1.observers.*;
import Ex3_1.subject.*;

public class Start {
  public static void main(String[] args) throws InterruptedException {
    TrafficLight light = new TrafficLight();
    LightObserver car1 = new Car(1);
    LightObserver car2 = new Car(2);
    LightObserver speedyCar = new SpeedyCar(3);
    light.addObserver(car1);
    light.addObserver(car2);
    light.addObserver(speedyCar);
    light.start();
  }
}
