package client.model.login;

import shared.AccessType;
import shared.LoginUser;

public interface Login
{
  AccessType login(LoginUser user);
}
