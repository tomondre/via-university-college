package Ex2_6;

public class Start
{
  public static void main(String[] args)
  {

    Bar bar = new Bar(5);

    Customer cus1 = new Customer(bar);
    Customer cus2 = new Customer(bar);
    Customer cus3 = new Customer(bar);
    Thread cusT1 = new Thread(cus1);
    Thread cusT2 = new Thread(cus2);
    Thread cusT3 = new Thread(cus3);

    Bartender bar1 = new Bartender(bar);
    Bartender bar2 = new Bartender(bar);
    Bartender bar3 = new Bartender(bar);
    Thread barT1 = new Thread(bar1);
    Thread barT2 = new Thread(bar2);
    Thread barT3 = new Thread(bar3);

    barT1.start();
    barT2.start();
    barT3.start();
    cusT1.start();
    cusT2.start();
    cusT3.start();
  }
}
