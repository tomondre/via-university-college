package Ex22_2.shared;

import java.io.Serializable;

public class Message implements Serializable
{
  private String time;
  private String senderName;
  private String text;

  public Message(String time, String senderName, String text)
  {
    this.time = time;
    this.senderName = senderName;
    this.text = text;
  }

  public String get()
  {
    return time + " " + senderName + ": " + text;
  }

  public String getName()
  {
    return senderName;
  }

  public String getText()
  {
    return text;
  }

}
