package client.model.doctor;

import client.model.manager.EmployeeModelManager;
import client.model.manager.EmployeeModelManagerImpl;
import client.networking.doctor.NurseClientDoctor;
import client.networking.doctor.NurseClientDoctorRMI;
import client.networking.manager.EmployeeClientManager;
import client.networking.manager.EmployeeClientRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Address;
import shared.Doctor;
import shared.Nurse;
import shared.Ward;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NursesModelDoctorTest
{
  private NursesModelDoctor test;
  private EmployeeModelManager dummyDataManager;
  private Nurse dummyNurse;
  private Doctor dummyDoctor;

  @BeforeEach public void setUp()
  {
    EmployeeClientManager c = new EmployeeClientRMI();
    dummyDataManager = new EmployeeModelManagerImpl(c);

    NurseClientDoctor client = new NurseClientDoctorRMI();
    test = new NursesModelDoctorImpl(client);

    createDummyNurse();
    createDummyDoctor();
  }

  @AfterEach public void undo()
  {
    removeDummyNurse();
    removeDummyDoctor();
  }

  @Test public void getAllAvailableNurses()
  {
    ArrayList<Nurse> allAvailableNurses = test.getAllAvailableNurses();
    assertNotEquals(null, allAvailableNurses);
  }

  @Test public void assignNurse()
  {
    test.assignNurse(dummyNurse, dummyDoctor);

    boolean isAssigned = false;
    for (Nurse nurse : test.getAllNursesAssignedToMe(dummyDoctor))
    {
      if (nurse.getSsn() == dummyNurse.getSsn()
          && nurse.getDoctor_ssn() == dummyDoctor.getSsn())
      {
        isAssigned = true;
        break;
      }
    }

    assertTrue(isAssigned);
  }

  @Test public void getAllNursesAssignedToMe()
  {
    test.assignNurse(dummyNurse, dummyDoctor);

    ArrayList<Nurse> allNursesAssignedToMe = test.getAllNursesAssignedToMe(dummyDoctor);
    assertTrue(0 < allNursesAssignedToMe.size());
  }

  private void createDummyNurse()
  {
    dummyNurse = new Nurse(1010101010L, 0, "Test", "", "", new Date(12312),
        new Address("", "", "", ""), "", "", "", "", new Date(1234), "", "",
        "123@123.com", "123Abcd123");
    dummyDataManager.addNurse(dummyNurse);
  }

  private void removeDummyNurse()
  {
    dummyDataManager.removeNurse(dummyNurse);
  }

  private void createDummyDoctor()
  {
    dummyDoctor = new Doctor("", "", "", 1234567899L, null,
        new Address("", "", "", ""), "", "", "", "", null, "", "",
        new Ward("Examination", 100), "a@gmail.com", "123Abcdef");
    dummyDataManager.addDoctor(dummyDoctor);
  }

  private void removeDummyDoctor()
  {
    dummyDataManager.removeDoctor(dummyDoctor);
  }
}
