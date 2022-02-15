public abstract class BillableItem
{
  private String date;
  private String recipientNo;

  public BillableItem(String date, String receiptNo)
  {
    this.date = date;
    this.recipientNo = receiptNo;
  }

  public String getDate()
  {
    return date;
  }

  public String getRecipientNo()
  {
    return recipientNo;
  }

  public abstract double getPrice();
}
