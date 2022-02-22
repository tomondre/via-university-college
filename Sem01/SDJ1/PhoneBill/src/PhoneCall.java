public class PhoneCall extends BillableItem
{
  private int minute;
  private double pricePerMinute;

  public PhoneCall(String date, String recipientNo, int minute, double pricePerMinute)
  {
    super(date,recipientNo);
    this.minute = minute;
    this.pricePerMinute = pricePerMinute;
  }
  public int getMinutes()
  {
    return minute;
  }

  public double getPrice()
  {
    return minute*pricePerMinute;
  }
}
