package Ex19_2;

import java.util.ArrayList;

public class DBPersonStorage implements PersonStorage
{
  private ArrayList<Person> people;

  public DBPersonStorage()
  {
    people = new ArrayList<>();
  }

  @Override public void addPerson(Person prs)
  {
    people.add(prs);
  }

  @Override public Person getPerson(int ssn)
  {
    for (Person person : people)
    {
      if (person.getSsn() == ssn)
      {
        return person;
      }
    }
    throw new IllegalStateException();
  }
}
