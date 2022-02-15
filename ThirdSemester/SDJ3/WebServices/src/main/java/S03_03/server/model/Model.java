package S03_03.server.model;


import S03_03.shared.User;

import java.util.ArrayList;

public class Model
{
  private ArrayList<User> users;

  public Model()
  {
    users = new ArrayList<>();
  }

  public boolean createUser(int id, String email, String password)
  {
    User user = new User(id, email, password);
    users.add(user);
    return true;
  }

  public boolean validateUser(int id)
  {
    for (User user : users)
    {
      if (user.getId() == id)
      {
        return true;
      }
    }
    return false;
  }

  public boolean changePassword(int id, String password)
  {
    for (User user : users)
    {
      if (user.getId() == id)
      {
        users.get(id).setPassword(password);
        return true;
      }
    }
    return false;
  }

  public boolean deleteUser(int id)
  {
    for (User user : users)
    {
      if (user.getId() == id)
      {
        users.remove(user.getId());
        return true;
      }
    }
    return false;
  }
}
