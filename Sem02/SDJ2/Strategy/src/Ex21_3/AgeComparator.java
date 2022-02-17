package Ex21_3;

public class AgeComparator implements Comparator
{
  @Override public int compare(Person person1, Person person2)
  {
    return person1.getAge() - person2.getAge();
  }
}
