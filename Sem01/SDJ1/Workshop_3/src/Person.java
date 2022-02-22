public class Person
{
  private char gender;
  private Name name;

  public Person(char gender, Name name)
  {
    this.gender = gender;
    this.name = name.copy();
  }

  public void setName(Name name){
    this.name = name.copy();
  }
  public void setName(String firstName, String lastName){
  name.setFirstName(firstName);
  name.setLastName(lastName);
  }
  public Name getName(){
    return name.copy();
  }
  public String getFullName(){
 return name.getFirstName() + " "+ name.getLastName();
}
public boolean isFemale(){
    return gender=='F'||gender=='f';
}
  @Override public String toString()
  {
    return "Person{" + "gender=" + gender + ", name=" + name + '}';
  }
  public boolean equals(Object obj){
    if (!(obj instanceof Person)){return false;}
    Person other = (Person)obj;
    return gender== other.gender&& name.equals(other.name);
  }
}