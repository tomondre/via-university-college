public class Student_test
{
  public static void main(String[] args)
  {
    Student stu1 = new Student("Peter", 'M',301450);
    Student stu2 = new Student("Veronika", 'F',301450);
    Student stu3 = new Student("Marek", 'M',301450);

    System.out.println(stu1);
    System.out.println(stu3);
    System.out.println(stu2);

    stu1.setName("Filip");
    stu2.setId(00000);
    System.out.println(stu3.getGender());
    System.out.println(stu2.getId());
    System.out.println(stu1.getName());
  }
}
