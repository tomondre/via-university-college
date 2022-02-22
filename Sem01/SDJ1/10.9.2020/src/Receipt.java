public class Receipt
{
private int room;
private String name, period;

public void receipt(int room, String name, String period)
{
this.room = room;
this.name = name;
this.period = period;
}

  @Override public String toString()
  {
    return "Receipt{" + "room=" + room + ", name='" + name + '\'' + ", period='"
        + period + '\'' + '}';
  }
}
