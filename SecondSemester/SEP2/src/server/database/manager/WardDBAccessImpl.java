package server.database.manager;

import server.database.DatabaseAccess;
import shared.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//TODO not all methods are necessary
public class WardDBAccessImpl implements WardDBAccessManager
{
  @Override public void addWard(Ward ward)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO ward(ward_name, room_number) VALUES (?, ?)"))
    {
      preparedStatement.setString(1, ward.getWardName());
      preparedStatement.setInt(2, ward.getRoomNumber());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void editWard(Ward oldWard, Ward newWard)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE ward SET ward_name = ?, room_number = ? WHERE ward_name = ? AND room_number = ?"))
    {
      preparedStatement.setString(1, newWard.getWardName());
      preparedStatement.setInt(2, newWard.getRoomNumber());

      preparedStatement.setString(3, oldWard.getWardName());
      preparedStatement.setInt(4, oldWard.getRoomNumber());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void removeWard(Ward ward)
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE FROM ward where ward_name = ? and room_number = ?"))
    {
      preparedStatement.setString(1, ward.getWardName());
      preparedStatement.setInt(2, ward.getRoomNumber());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<Ward> getAllWards()
  {
    try (Connection connection = DatabaseAccess.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM ward"))
    {
      ResultSet r = preparedStatement.executeQuery();

      ArrayList<Ward> result = new ArrayList<>();

      while (r.next())
      {
        result.add(new Ward(r.getString("ward_name"), r.getInt("room_number")));
      }

      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
