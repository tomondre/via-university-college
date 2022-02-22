package Apartment;

public class Test
{
  public static void main(String[] args)
  {
    MyDate md1 = new MyDate(25,10,2020);
    Tenant tenant = new Tenant("Tomas");
    Apartment a1 = new Apartment(25);
    Apartment a2 = new Apartment(28);
    Apartment a3 = new Apartment(29);
    Apartment a4 = new Apartment(26);
    ApartmentComplex complex = new ApartmentComplex("Mik doh");
    complex.add(a1);
    complex.add(a2);
    complex.add(a3);
    complex.add(a4);
    a1.rentTo(tenant,md1);
    System.out.println(complex.getFirstAvailableApartment());
    System.out.println(complex.getApartmentByNumber(25));




  }
}
