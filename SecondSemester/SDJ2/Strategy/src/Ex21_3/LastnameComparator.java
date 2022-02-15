package Ex21_3;

public class LastnameComparator implements Comparator
{
  @Override public int compare(Person person1, Person person2)
  {
    return person1.getLastName().compareTo(person2.getLastName());
  }
}
