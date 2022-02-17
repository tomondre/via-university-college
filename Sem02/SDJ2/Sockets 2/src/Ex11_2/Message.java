package Ex11_2;

import java.io.Serializable;

public class Message implements Serializable
{
  private String message;


  public Message(String msg)
  {
    this.message = msg;
  }

  public String get()
  {
    return message;
  }

  public String toString()
  {
    return message;
  }

  public String toUpperCase()
  {
    return message.toUpperCase();
  }
}
