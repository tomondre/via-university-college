package Coountry;

public class mAIN
{
  public static void main(String[] args)
  {
    Forest forest = new Forest(15);
    forest.addAnimal(new Spider(5,15));
    forest.addAnimal(new Squirrel(30));
    forest.addAnimal(new Squirrel(20));
    forest.addAnimal(new Squirrel(15));
    forest.addAnimal(new Squirrel(50));
    forest.addAnimal(new Squirrel(40));
    forest.addAnimal(new Squirrel(60));
    forest.addAnimal(new Squirrel(5));
    forest.addAnimal(new Spider(25, 6));

    Animal[] temp = forest.getAllAnimals();
    for(Animal animal:temp)
    {
      System.out.println(animal);
    }
    System.out.println("-----");
    temp = forest.getOrderedSquirrels();
    for(Animal animal:temp)
    {
      System.out.println(animal);
    }

    Country country = new Country("Llolo", false);
    country.growForest(forest);

    Forest f1 = new Forest(15);
    f1.addAnimal(new Spider(5,15));
    f1.addAnimal(new Squirrel(30));
    f1.addAnimal(new Squirrel(20));
    f1.addAnimal(new Squirrel(15));
    f1.addAnimal(new Squirrel(50));
    f1.addAnimal(new Squirrel(40));
    f1.addAnimal(new Spider(25, 6));


    Forest f2 = new Forest(15);
    f2.addAnimal(new Spider(5,15));
    f2.addAnimal(new Squirrel(30));
    f2.addAnimal(new Squirrel(20));
    f2.addAnimal(new Squirrel(15));
    f2.addAnimal(new Squirrel(50));
    f2.addAnimal(new Spider(25, 6));


    Forest f3 = new Forest(15);
    f3.addAnimal(new Spider(5,15));
    f3.addAnimal(new Squirrel(30));

    country.growForest(f1);
    country.growForest(f2);
    country.growForest(f3);
    Forest[] tempForest = country.getAllForest();
    for (Forest fore:tempForest)
    {
      System.out.println(fore);
    }
    System.out.println("-------");
tempForest = country.getOrderedForest();
    for (Forest fore:tempForest)
    {
      System.out.println(fore);
    }

  }
}
