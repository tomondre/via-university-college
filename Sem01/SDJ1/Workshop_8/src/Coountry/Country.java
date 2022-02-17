package Coountry;

import java.util.ArrayList;

public class Country
{
  private String name;
  private boolean sea;
  private int numOfForest;
  private ArrayList<Forest> forests;

  public Country(String name, boolean sea)
  {
    this.name = name;
    this.sea = sea;
    forests = new ArrayList<Forest>();
  }

  public void growForest(Forest forest)
  {
    forests.add(forest);
  }

  public Forest[] getAllForest()
  {
    return forests.toArray(new Forest[forests.size()]);
  }

  public Forest[] getOrderedForest()
  {
    Forest temp;
    Forest[] tempList = new Forest[forests.size()];
    boolean working = true;
    for (int i = 0; i < forests.size(); i++)
    {
      tempList[i] = forests.get(i);
    }
    while (working)
    {
      working = false;
      for (int i = 0; i < tempList.length - 1; i++)
      {
        if (tempList[i].getNumberOfAnimals() < tempList[i + 1]
            .getNumberOfAnimals())
        {
          temp = tempList[i];
          tempList[i] = tempList[i + 1];
          tempList[i + 1] = temp;
          working = true;
        }
      }

    }
    return tempList;

  }

  public String getName()
  {
    return name;
  }

  public boolean hasSea()
  {
    return sea;
  }

  public int getNumOfForest()
  {
    return forests.size();
  }

}
