package server.model.login;

import shared.AccessType;
import shared.LoginUser;

public interface LoginServerModel
{
    AccessType login(LoginUser user);
}
