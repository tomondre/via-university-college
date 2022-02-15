public class Temperature
{
  double ftemp;
  double b;
  public Temperature(double ftemp)
  {
    this.ftemp = ftemp;
  }
  public void setFtemp(double s)
  {
    ftemp= s;
  }
  public double getFtemp()
  {
    return ftemp;
  }
  public double getCelsius()
  {
    b = (ftemp -32) * (5.0/9);
    return b;
  }

  public double getKelvin()
  {
    b =  ((5.0/9)*(ftemp -  32)) * 273;
    return b ;
  }

  public String toString()
  {
    return "Ftemp " + ftemp;
  }
}
