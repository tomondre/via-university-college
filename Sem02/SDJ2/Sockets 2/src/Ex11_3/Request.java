package Ex11_3;

import java.io.Serializable;

public class Request implements Serializable
{
  private String arg;
  private String requestType;

  public Request(String requestType, String arg)
  {
    this.arg = arg;
    this.requestType = requestType;
  }

  public String getArg()
  {
    return arg;
  }

  public String getRequestType()
  {
    return requestType;
  }
}
