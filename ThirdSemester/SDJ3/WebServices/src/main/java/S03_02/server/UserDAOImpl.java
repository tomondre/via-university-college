package S03_02.server;

import S03_02.shared.User;
import S03_03.server.UserDAO;


@WebService(endpointInterface = "main.java.S03_02.server.UserDAO")
public class UserDAOImpl implements UserDAO
{
  private User user = new User();

  @Override public int getId()
  {
    int id = user.getId();
    System.out.println("Getting user ID: " + id);
    return id;
  }

  @Override public void setId(int id)
  {
    System.out.println("Setting user ID: " + id);
    user.setId(id);
  }

  @Override public String getEmail()
  {
    String email = user.getEmail();
    System.out.println("Getting user email: " + email);
    return email;
  }

  @Override public void setEmail(String email)
  {
    System.out.println("Setting user email: " + email);
    user.setEmail(email);
  }

  @Override public String getPassword()
  {
    String password = user.getPassword();
    System.out.println("Getting user password: " + password);
    return password;
  }

  @Override public void setPassword(String password) {
    System.out.println("Setting user password: " + password);
    user.setPassword(password);
  }
}
