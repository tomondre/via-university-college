public class JobTest
{
  public static void main(String[] args)
  {
    Person person1 = new Person("Marek", "10.2.2002");
    Job job1 = new Job("HR", 1000, person1);
    Person person2 = new Person("Peter", "11.5.1999");
    Job job2 = new Job("worker", 1500, person2);

    System.out.println(job1);
    System.out.println(job2);

    System.out.println(job1.getSalary());
    job1.givePercentageRaise(10);
    job1.setTitle("runner");
    System.out.println(job1.getSalary());
    System.out.println(job1);
  }
}
