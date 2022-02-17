package S03_02.client;


import S03_03.server.UserDAO;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class UserDAOClient
{
  public static void main(String[] args) throws Exception
  {
    URL url = new URL("http://localhost:9999/user?wsdl");
    QName qname = new QName("http://server.S03_02.java.main/", "UserDAOImplService");
    Service service = Service.create(url, qname);
    UserDAO userDAO = service.getPort(UserDAO.class);
    userDAO.setPassword("Halabala");
    System.out.println(userDAO.getPassword());
  }
}
