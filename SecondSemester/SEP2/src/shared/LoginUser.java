package shared;

import java.io.Serializable;

public class LoginUser implements Serializable
{
  private String username;
  private String password;
  private AccessType accessType;

  public LoginUser(String username, String password, AccessType accessType)
  {
    this.username = username;
    this.password = password;
    this.accessType = accessType;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public AccessType getAccessType()
  {
    return accessType;
  }
}
