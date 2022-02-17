package Coountry;

public abstract class Animal
{
private int legs;
public Animal(int legs)
{
  this.legs = legs;
}

public int getLegs()
{
  return legs;
}

public abstract String getSound();

public String toString()
{
  return "Legs: " + legs;
}




}
