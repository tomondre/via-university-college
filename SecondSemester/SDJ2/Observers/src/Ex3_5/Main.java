package Ex3_5;

public class Main
{
  public static void main(String[] args)
  {
    Bird peacock = new Bird("Peacock");
    BirdWatcher birdWatcher = new BirdWatcher("Peter");

    peacock.addPropertyListener(birdWatcher);

    peacock.start(5);
  }
}
