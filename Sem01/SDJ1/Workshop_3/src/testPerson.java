public class testPerson
{
  public static void main(String[] args)
  {
Name n = new Name("Tomas","Ondrejka");
Person p = new Person('M',n);
    System.out.println(p);
p.setName("Ono","toto");
    System.out.println(p.isFemale());

    System.out.println(p);
  }
}
