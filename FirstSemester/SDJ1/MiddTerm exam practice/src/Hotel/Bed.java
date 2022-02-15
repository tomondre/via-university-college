package Hotel;

public class Bed
{
  private String type;

  public Bed(String type)
  {
    this.type = type;
  }

  public boolean isSingle()
  {
    return type.equals("Single");
  }

  public boolean isDouble()
  {
    return type.equals("Double");
  }


  public boolean isKingSize()
  {
    return type.equals("KingSize");
  }
}
