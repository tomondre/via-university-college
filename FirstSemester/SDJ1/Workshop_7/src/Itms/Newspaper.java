package Itms;

public class Newspaper extends Item
{
  private int week;

  public Newspaper(int week, double price)
  {
    super(price);
    this.week = week;
  }

  public int getWeek()
  {
    return week;
  }

  public String toString()
  {
    return super.toString() + ", Week: " + week;
  }

  public boolean equals(Object obj)
  {

    if (!(obj instanceof Newspaper))
    {
      return false;
    }
    Newspaper other = (Newspaper) obj;

    return super.equals(other) && week == other.week;
  }

  public String getType()
  {
    return "Newspaper";
  }
}
