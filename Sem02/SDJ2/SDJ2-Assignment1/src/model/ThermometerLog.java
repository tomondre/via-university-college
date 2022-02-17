package model;

import java.util.ArrayList;

public class ThermometerLog
{
  private final ArrayList<Double> list;

  public ThermometerLog()
  {
    list = new ArrayList<Double>();
    list.add((double) 20);
  }

  //Round the number before adding
  public void add(double value)
  {
    list.add(Math.round(value * 100.0) / 100.0);
  }

  public double getLastValue()
  {
    return list.get(list.size() - 1);
  }

  public ArrayList<Double> getHistoryValues()
  {
    return list;
  }
}
