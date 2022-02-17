package VehicleList;

public class Engine
{
  private int horsePower, volume;
  private boolean isDiesel;
  private  String type;

  public Engine(int horsePower, String type)
  {
    this.horsePower = horsePower;
    this.type = type;
  }

  public int getHorsePower()
  {
    return horsePower;
  }

  public int getVolume()
  {
    return volume;
  }

  public boolean isDiesel()
  {
    return isDiesel;
  }

  public String getType()
  {
    return type;
  }
  @Override public String toString()
  {
    return "horsePower=" + horsePower + ", volume=" + volume
        + ", isDiesel=" + isDiesel + ", type='" + type + '\'' + '}';
  }
  public boolean equals(Object obj){
    if (!(obj instanceof Engine)){
      return false;
    }
    Engine other = (Engine)obj;
    return type.equals(other.type)&&horsePower==other.horsePower&&
        volume==other.volume&&isDiesel==other.isDiesel;
  }

}
