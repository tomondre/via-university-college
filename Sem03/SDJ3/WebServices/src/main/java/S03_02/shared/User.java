package S03_02.shared;

public class User
{
  private int id;
  private String email;
  private String password;

  public User()
  {
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  @Override public String toString()
  {
    return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='"
        + password + '\'' + '}';
  }
}
