package client.model.login;

import client.model.manager.EmployeeModelManager;
import client.model.manager.EmployeeModelManagerImpl;
import client.networking.login.LoginClient;
import client.networking.login.LoginClientImpl;
import client.networking.manager.EmployeeClientManager;
import client.networking.manager.EmployeeClientRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.networking.login.LoginServerRMI;
import shared.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest
{
  private Login test;
  private EmployeeModelManager manager;
  private Doctor dummyDoctor;

  @BeforeEach public void setup()
  {
    LoginClient client = new LoginClientImpl();
    test = new LoginImpl(client);
    createLogin();
  }

  @AfterEach public void undo()
  {
    manager.removeDoctor(dummyDoctor);
  }

  @Test public void login()
  {

    LoginUser user = new LoginUser("test@test.com", "qwer12334A", AccessType.DOCTOR);
    AccessType login = test.login(user);
    assertEquals(AccessType.DOCTOR, login);

    LoginUser wrongUser = new LoginUser("test@test.com", "Ceo2345", AccessType.DOCTOR);
    AccessType wrongLogin = test.login(wrongUser);
    assertEquals(AccessType.NO_ACCESS, wrongLogin);
  }

  private void createLogin()
  {
    EmployeeClientManager client = new EmployeeClientRMI();
    manager = new EmployeeModelManagerImpl(client);
    dummyDoctor = new Doctor("", "", "", 1010101010L, null, new Address("","","",""), null, null,
        null, null, null, null, null, new Ward("Examination", 100), "test@test.com", "qwer12334A");

    manager.addDoctor(dummyDoctor);
  }
}