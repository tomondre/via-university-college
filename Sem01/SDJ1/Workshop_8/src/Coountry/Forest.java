package Coountry;

import java.util.ArrayList;

public class Forest
{
  private int numberOfTrees;
  private int numberOfAnimals;
  private ArrayList<Animal> animals;

  public Forest(int numberOfTrees)
  {
    this.numberOfTrees = numberOfTrees;
    animals= new ArrayList<Animal>();
  }

  public void addAnimal(Animal animal)
  {
    animals.add(animal);
    numberOfAnimals++;
  }

  public void plantTree()
  {
    numberOfTrees++;
  }

  public int getNumberOfAnimals()
  {
    return animals.size();
  }

  public int getNumberOfTrees()
  {
    return numberOfTrees;
  }

  public Animal[] getAllAnimals()
  {
    return animals.toArray(new Animal[animals.size()]);
  }

  public Animal[] getAnimalsOfType(String type)
  {
    ArrayList<Animal> temp = new ArrayList<Animal>();
    Object tempOb;
    if (type.equals("Bear"))
    {
      for (Animal animal : animals)
      {
        if (animal instanceof Bear)
        {
          temp.add(animal);
        }
      }
    }
    if (type.equals("Spider"))
    {
      for (Animal animal : animals)
      {
        if (animal instanceof Spider)
        {
          temp.add(animal);
        }
      }
    }
    if (type.equals("Squirrel"))
    {
      for (Animal animal : animals)
      {
        if (animal instanceof Squirrel)
        {
          temp.add(animal);
        }
      }
    }
    return temp.toArray(new Animal[temp.size()]);

    //
    //    ArrayList<Animal> temp = new ArrayList<Animal>();
    //    for (Animal animal : animals)
    //    {
    //      if (animal.getClass().equals(type))
    //      {
    //        temp.add(animal);
    //      }
    //    }
    //    return temp.toArray(new Animal[temp.size()]);
  }

  public Animal[] getOrderedSquirrels()
  {
    Animal temp;
    boolean working = true;
    Animal[] tempList = getAnimalsOfType("Squirrel");

    while (working)
    {
      working = false;
      for (int i = 0; i < tempList.length - 1; i++)
      {
        if (((Squirrel) tempList[i]).getMaxSpeed() < ((Squirrel) tempList[i
            + 1]).getMaxSpeed()&&i<tempList.length - 1)
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

  public int getNumberOfSleepingBears()
  {
    int temp = 0;
    for (Animal animal : animals)
    {
      if (animal instanceof Bear && ((Bear) animal).isASleep())
      {
        temp++;
      }
    }
    return temp;
  }

  public String toString()
  {
    return animals + ", numberOfAnimals: " + numberOfAnimals + ",  ";
  }

}
