package S03_03.server;

import javax.wsdl.extensions.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserDAO
{
  @WebMethod boolean createUser(int id, String email, String password);
  @WebMethod boolean validateUser(int id);
  @WebMethod boolean changePassword(int id, String password);
  @WebMethod boolean deleteUser(int id);
}
