package Ex20_2;

import static Ex20_2.PersonType.*;

public class RunSeaBear
{
  public static void main(String[] args)
  {
    VisitSeaBear seaBear = new SeaBear();
    SeaBearGuard guard = new SeaBearGuard(seaBear);

    System.out.println("1. attempt");
    guard.feed(CHILDREN);

    System.out.println("2. attempt");
    guard.feed(ZOOKEEPER);

    System.out.println("3. attempt");
    guard.pet(CHILDREN);

    System.out.println("4. attempt");
    guard.pet(ADULT);

    System.out.println("5. attempt");
    guard.view(MOTHER_IN_LAW);
  }
}
