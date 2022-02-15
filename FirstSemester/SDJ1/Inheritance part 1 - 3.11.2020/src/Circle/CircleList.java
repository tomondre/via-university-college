package Circle;

import java.util.ArrayList;

public class CircleList
{
  private int capacity;
  ArrayList<Circle> list;

  public CircleList(int capacity)
  {
    list = new ArrayList<Circle>(capacity);
  }
  public int getNumberOfCircles()
  {
    return list.size();
  }

  public void addCircle(Circle circle)
  {
    list.add(circle);
  }

  public Circle getCircle(int index)
  {
    return list.get(index);
  }

  public double getTotalArea()
  {
    int total = 0;
    for (int i = 0; i < list.size(); i++)
    {
      total+=list.get(i).getArea();
    }
    return total;
  }
  public double getAvarageArea()
  {
    return getTotalArea()/list.size();
  }

}
