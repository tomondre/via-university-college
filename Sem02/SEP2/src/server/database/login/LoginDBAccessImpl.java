package server.database.login;

import server.database.DatabaseAccess;
import shared.AccessType;
import shared.LoginUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDBAccessImpl implements LoginDBAccess
{
  @Override public AccessType login(LoginUser user)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection())
    {
      Statement statement = connection.createStatement();

      String query = "SELECT password FROM " + user.getAccessType().toString()
          + " WHERE email = '" + user.getUsername() + "'";

      ResultSet resultSet = statement.executeQuery(query);

      resultSet.next();
      String passwordFromDB = resultSet.getString("password");

      if (passwordFromDB.equals(user.getPassword()))
      {
        return user.getAccessType();
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    } return AccessType.NO_ACCESS;
  }
}
