package server.model.login;

import server.database.login.LoginDBAccess;
import server.database.login.LoginDBAccessImpl;
import shared.AccessType;
import shared.LoginUser;

public class LoginServerModelImpl implements LoginServerModel
{
    private LoginDBAccess loginDBAccess;

    public LoginServerModelImpl()
    {
        this.loginDBAccess = new LoginDBAccessImpl();
    }

    @Override
    public AccessType login(LoginUser user)
    {
        return loginDBAccess.login(user);
    }
}
