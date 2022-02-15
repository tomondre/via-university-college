package server.database.login;

import shared.AccessType;
import shared.LoginUser;

public interface LoginDBAccess
{
    AccessType login(LoginUser user);
}
