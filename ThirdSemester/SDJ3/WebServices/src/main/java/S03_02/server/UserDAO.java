package S03_02.server;


import javax.wsdl.extensions.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserDAO
{
  @WebMethod int getId();
  @WebMethod void setId(int id);
  @WebMethod String getEmail();
  @WebMethod void setEmail(String email);
  @WebMethod String getPassword();
  @WebMethod void setPassword(String password);
  @WebMethod String toString();
}
