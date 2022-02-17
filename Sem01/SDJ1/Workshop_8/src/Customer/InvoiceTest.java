package Customer;

public class InvoiceTest
{
  public static void main(String[] args)
  {
    Customer customer = new Person("Tomas", "Nygade 11", 25);
    Invoice invoice = new Invoice(customer);
    invoice.addItem(new Item(25, true));
    invoice.addItem(new Item(30, true));
    invoice.addItem(new Item(10, true));
    invoice.addItem(new Item(20, true));
    invoice.addItem(new Item(20, true));
    Item[] temp = invoice.getListOfITems();
    for (Item item:temp)
    {
      System.out.println(item);
    }
    System.out.println("----------");
    temp = invoice.getSortedListOfFragileItems();

    for (Item item:temp)
    {
      System.out.println(item);
    }


  }
}
