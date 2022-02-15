package Ex12_1.shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private Object obj;
  private String requestType;

  public Request(String requestType, Object obj)
  {
    this.obj = obj;
    this.requestType = requestType;
  }

  public Object getArg()
  {
    return obj;
  }

  public String getRequestType()
  {
    return requestType;
  }
}
