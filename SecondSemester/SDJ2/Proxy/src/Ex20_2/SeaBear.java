package Ex20_2;

public class SeaBear implements VisitSeaBear
{
  @Override public void view(PersonType personType)
  {
    System.out.println("Bear is being viewed by " + personType);
  }

  @Override public void feed(PersonType personType)
  {
    System.out.println("Bear is being fed by " + personType);
  }

  @Override public void pet(PersonType personType)
  {
    System.out.println("Bear is being pet by " + personType);
  }
}
