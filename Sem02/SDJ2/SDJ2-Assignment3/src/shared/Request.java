package shared;

import java.io.Serializable;

public class Request implements Serializable
{
  private RequestType request;
  private Object arg;

  public Request(RequestType type, Object arg)
  {
    this.request = type;
    this.arg = arg;
  }

  public RequestType getRequest()
  {
    return request;
  }

  public Object getArg()
  {
    return arg;
  }

  public void setRequest(RequestType request)
  {
    this.request = request;
  }

  public void setArg(Object arg)
  {
    this.arg = arg;
  }
}
