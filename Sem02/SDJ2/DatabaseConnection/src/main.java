import java.sql.*;

public class main
{
  public static void main(String[] args) throws SQLException
  {
    Connection con = null;
    try {
     con = DriverManager
          .getConnection("jdbc:postgresql://hattie.db.elephantsql.com:5432/yunjxnkw", "yunjxnkw", "D5YTBHvbbrXKkABkXyFqK-L4jQDNVsBH");
    } catch (SQLException e) {
      throw new RuntimeException("Failed to get DB connection!");
    }

    PreparedStatement s = con.prepareStatement("set schema 'dhms'");
    s.execute();

    PreparedStatement q = con.prepareStatement("select * from doctor");
    ResultSet r = q.executeQuery();


    ResultSetMetaData rsmd = r.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    while (r.next()) {
      for (int i = 1; i <= columnsNumber; i++) {
        if (i > 1) System.out.print(",  ");
        String columnValue = r.getString(i);
        System.out.print(columnValue + " " + rsmd.getColumnName(i));
      }
      System.out.println("");
    }

  }
}
