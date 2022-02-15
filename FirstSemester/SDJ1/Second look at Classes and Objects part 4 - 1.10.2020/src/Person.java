public class Person
{
private String name;
private MyDate mydate;
private Brain brain;
private Address address;
  public Person(String name, Address address, MyDate mydate) {
    this.name = name;
    this.address = address;
    this.mydate = mydate.copy();
    this.brain  = new Brain();
  }
  public Person(String name, MyDate birthday) {
    this.name = name;
    this.mydate = mydate.copy();
    this.brain  = new Brain();
  }
  public Person(MyDate mydate) {
    this.mydate = mydate.copy();
    this.brain  = new Brain();
  }
  public String getName()
  {
    return name;
  }
  public Address getAddress()
  {
    return address;
  }
  public String getShortAddress() {return address.getStreet() + " " + address.getNumber();}
  public MyDate getBirthday(){return mydate.copy();}
  public void setName(String name)
  {
    this.name = name;
  }
  public void setAddress(Address address)
  {
    this.address = address;
  }
  public void setBirthday(MyDate mydate)
  {
    this.mydate = mydate;
  }
  public int getIQ(){
return  brain.getIQ();
  }
  public boolean isBrainDamaged(){
    return brain.isBrainDamaged();
}
  public boolean doYouRemember(String topic){
    return brain.recall(topic);
}
  public void rememberThisTopic(String topic){
    if (brain.recall(topic)){
      brain.refreshMemory(topic);
    }
else brain.remember(topic);
}
  public String WhatAreYouThinkingAbout(){
    return brain.recall();
}
  @Override public String toString()  {
    return "Person{" + "name='" + name + '\'' + ", mydate=" + mydate
        + ", brain=" + brain + ", address=" + address + '}';
  }
  public boolean equals(Object obj){
    if (!(obj instanceof Person))
    {
      return false;
    }
    Person other = (Person)obj;
return mydate == other.mydate&&brain == other.brain&&name == other.name && address == other.address;
  }

  public static void main(String[] args){
    MyDate d = new MyDate(28,10,2000);
    Address a = new Address("Mikulasa","817","01004","Zilina","Slovakia");
    Person p = new Person("Tomas",d);
    System.out.println(p);
    System.out.println(p.getBirthday());
   p.rememberThisTopic("022255");
   p.rememberThisTopic("dsdsd");
    System.out.println(p);
//    System.out.println(p.WhatAreYouThinkingAbout());
    System.out.println(p.WhatAreYouThinkingAbout());

  }
}
