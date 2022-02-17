import java.util.Scanner;

public class LandTract
{
  private double length,width;
  public LandTract(double l, double w){
    length = l;
    width = w;
  }
  public void setLength(double length)
  {
    this.length = length;
  }
  public void setWidth(double width)
  {
    this.width = width;
  }
  public double getLength()
  {
    return length;
  }
  public double getWidth()
  {
    return width;
  }
  public double area(){
    return length*width;
  }
  public boolean equals(LandTract l){
    if (area()==l.area())
    {
      return true;
    }
    else return false;
  }

public String toString(){
    return "LandTract{" + "length=" + length + ", width=" + width + '}';
  }
}
