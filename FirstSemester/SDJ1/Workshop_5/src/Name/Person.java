package Name;
import java.util.ArrayList;
public class Person
{
  private Name name;
  private ArrayList<Pet> pets;
  public Person(String namee)
  {
    pets = new ArrayList<Pet>();
    String[] arrOfStr = namee.split(" ");
    name = new Name(arrOfStr[0],arrOfStr[1]);
  }
  public String getName()
  {
    return name.getFullName();
  }

  public void buyAPet(Pet pet)
  {
    pets.add(pet);
  }
  public ArrayList<Pet> getAllPets()
  {
    return pets;
  }
  public Pet getPetBy(Name name)
  {
    for (int i = 0; i < pets.size(); i++)
    {
      if(pets.get(i).getName().equals(name))
      {
        return pets.get(i);
      }
    }
    return null;
  }


  public static void main(String[] args){
  Person person = new Person("Toams Ondrejka");
    System.out.println(person.getName());

  }

}
