import java.util.ArrayList;

public class PhoneBill
{
  private String phoneNo;
  private ArrayList<BillableItem> items;

  public PhoneBill(String phoneNo)
  {
    this.phoneNo = phoneNo;
    items = new ArrayList<BillableItem>();
  }

  public void addItem(BillableItem item)
  {
    items.add(item);
  }

  public double getAmountDue()
  {
    double temp = 0;

    for (int i = 0; i < items.size(); i++)
    {
      temp += items.get(i).getPrice();
    }

    return temp;
  }

  public double getPhoneCallMinutes()
  {
    double temp = 0;
    for (int i = 0; i < items.size(); i++)
    {
      if (items.get(i) instanceof PhoneCall)
      {
        temp += ((PhoneCall) items.get(i)).getMinutes();
      }
    }
    return temp;
  }

  public ArrayList<TextMessage> getTextMessages()
  {
    ArrayList<TextMessage> temp = new ArrayList<TextMessage>();

    for (int i = 0; i < items.size(); i++)
    {
      if (items.get(i) instanceof TextMessage)
      {
        temp.add((TextMessage) items.get(i));
      }
    }
    return temp;
  }
}
