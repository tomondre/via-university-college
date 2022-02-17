package S03_03.server;


import S03_03.server.model.Model;

@WebService(endpointInterface = "main.java.S03_03.server.UserDAO")
public class UserDAOImpl implements UserDAO
{
  private Model model = new Model();

  @Override public boolean createUser(int id, String email, String password)
  {
    boolean success = model.createUser(id, email, password);
    System.out.println("User creation: " + success);
    return success;
  }

  @Override public boolean validateUser(int id)
  {
    boolean success = model.validateUser(id);
    System.out.println("User validation: " + success);
    return success;
  }

  @Override public boolean changePassword(int id, String password)
  {
    boolean success = model.changePassword(id, password);
    System.out.println("User password change: " + success);
    return success;
  }

  @Override public boolean deleteUser(int id)
  {
    boolean success = model.deleteUser(id);
    System.out.println("User deletion: " + success);
    return success;
  }
}
