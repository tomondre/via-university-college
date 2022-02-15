package server.database;

import java.sql.*;

public class DatabaseAccess
{
  private String url = "jdbc:postgresql://hattie.db.elephantsql.com:5432/yunjxnkw?currentSchema=dhms";
  private String user = "yunjxnkw";
  private String pw= "D5YTBHvbbrXKkABkXyFqK-L4jQDNVsBH";

  private static DatabaseAccess instance = new DatabaseAccess();

  public synchronized Connection getConnection(){
    try {
      DriverManager.registerDriver(new org.postgresql.Driver());
      return DriverManager.getConnection(url,user,pw);
    } catch (SQLException e) {
      throw new RuntimeException("Failed to get DB connection!");
    }
  }

  public synchronized static DatabaseAccess getInstance()
  {
    return instance;
  }
}
