package Ex22_2;

public class RunCarrotSimulation
{
  public static void main(String[] args)
  {
    BlockingQueue queue = new BlockingQueue(5);

    Eater eater1 = new Eater(queue, 1);
    Eater eater2 = new Eater(queue, 2);
    Eater eater3 = new Eater(queue, 3);
    Eater eater4 = new Eater(queue, 4);

    Peeler peeler = new Peeler(queue);

    new Thread(eater1).start();
    new Thread(peeler).start();


  }
}
