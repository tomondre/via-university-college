package Car;
public class Car
{
  private String make, model, color;
  private Wheel wheel1, wheel2, wheel3, wheel4;
  private Date date;
  public Car(String make, String model, String color, Date mDate)
  {
    this.make = make;
    this.model = model;
    this.color = color;
    date = mDate.copy();
  }
  public String getMake()
  {
    return make;
  }
  public String getModel()
  {
    return model;
  }
  public String getColor()
  {
    return color;
  }
  public void setColor(String color)
  {
    this.color = color;
  }
  public Wheel getWheel(int position){
    if (position == 1){return wheel1;}
    else if (position == 2){return wheel2;}
    else if (position == 3){return wheel3;}
    else if (position == 4){return wheel4;}
  else return null;
  }
  public void setWheel(Wheel wheel, int position){
    if (position == 1){wheel1 = wheel;}
    else if (position == 2){wheel2 = wheel;}
    else if (position == 3){wheel3 = wheel;}
    else if (position == 4){wheel4 = wheel;}
  }
  public Date getManufactureDate()
  {
    return date.copy();
  }
  @Override public String toString()
  {
    return  "make: " + make + " model: " + model + " color: " + color +
        " wheel1: " + wheel1 + " date: " + date;
  }
}