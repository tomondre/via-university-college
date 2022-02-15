package Ex2_3;

public class Start
{
  public static void main(String[] args)
  {
    Thermometer meter = new Thermometer("ID", 15);
    Thread thread = new Thread(meter);

    thread.start();
  }
}
