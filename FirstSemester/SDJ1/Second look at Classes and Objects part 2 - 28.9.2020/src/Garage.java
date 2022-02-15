public class Garage
{
  private Car firstCar;
  private Car secondCar;

  public Garage()
  {
    firstCar = null;
    secondCar = null;
  }
  public boolean isParkingAreaTaken(int position)
  {
    if (position == 1)
    {
      return !(firstCar == null);
    }
    else
    {
      return !(secondCar == null);
    }
  }
  public void park(Car car, int position)
  {
    if (position == 1 && !isParkingAreaTaken(position))
    {
      firstCar = car;
    }
    else if (position == 2 && !isParkingAreaTaken(position))
    {
      secondCar = car;
    }
  }
  public Car leaveGarage(int position)
  {
    if (position == 1 && isParkingAreaTaken(position))
    {
      Car temp = firstCar;
      firstCar = null;
      return temp;
    }
    else if (position == 2 && isParkingAreaTaken(position))
    {
      Car temp = secondCar;
      secondCar = null;
      return temp;
    }
    else
      return null;
  }
  public String toString()
  {
    return "Garage:" + "\nFirst car: " + firstCar + "\nSecond car: " + secondCar;
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Garage))
    {
      return false;
    }
    if (obj == null)
    {
      return false;
    }
    Garage other = (Garage)obj;
    if (this.firstCar == null && other.firstCar == null
        && this.secondCar == null && other.secondCar == null)
    {
      return true;
    }
    else if (this.firstCar != null && other.firstCar == null
        && this.secondCar != null && other.secondCar == null)
    {
      return false;
    }
    else if (this.firstCar == null && other.firstCar != null
        && this.secondCar == null && other.secondCar != null)
    {
      return false;
    }
    else
      return this.firstCar.equals(other.firstCar)
          && this.secondCar.equals(other.secondCar);
  }
}
