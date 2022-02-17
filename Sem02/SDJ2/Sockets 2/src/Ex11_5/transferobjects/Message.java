package Ex11_5.transferobjects;

import java.io.Serializable;

public class Message implements Serializable
{
  private String text;

  public Message(String text)
  {
    this.text = text;
  }

  public String get()
  {
    return text;
  }
}
