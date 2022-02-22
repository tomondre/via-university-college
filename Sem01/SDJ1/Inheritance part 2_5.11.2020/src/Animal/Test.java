package Animal;

public class Test
{
  public static void main(String[] args)
  {
    Animal[] animals = new Animal[4];
    animals[0] = new Frog(15, "Green");
    animals[1] = new Bee(16, true);
    animals[2] = new Dog(19, "Piter", "Husky");
    animals[3] = new Cat(20, "Alzbetka", false);
    for (Animal a : animals)
    {
      System.out.println(a);
    }
    for (Animal a : animals)
    {
      System.out.println(a.speak());
    }
  }
}
