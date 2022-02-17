package Ex20_2;

import static Ex20_2.PersonType.CHILDREN;
import static Ex20_2.PersonType.ZOOKEEPER;

public class SeaBearGuard implements VisitSeaBear
{
  private VisitSeaBear seaBear;

  public SeaBearGuard(VisitSeaBear seaBear)
  {
    this.seaBear = seaBear;
  }

  @Override public void view(PersonType personType)
  {
    seaBear.view(personType);
  }

  @Override public void feed(PersonType personType)
  {
    if (personType == ZOOKEEPER)
    {
      seaBear.feed(personType);
    }
    else
    {
      System.out.println("Feeding denied by Guard");
    }
  }

  @Override public void pet(PersonType personType)
  {
    if (personType == CHILDREN)
    {
      seaBear.pet(personType);
    }
    else
    {
      System.out.println("Petting denied by Guard");
    }
  }
}
