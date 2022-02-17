package client.model.shared;

import client.model.manager.EmployeeModelManager;
import client.model.manager.EmployeeModelManagerImpl;
import client.model.nurse.PatientModelNurseImpl;
import client.networking.manager.EmployeeClientManager;
import client.networking.manager.EmployeeClientRMI;
import client.networking.nurse.PatientClientNurse;
import client.networking.nurse.PatientClientNurseRMI;
import client.networking.shared.GetEmployeeDataClient;
import client.networking.shared.GetEmployeeDataClientRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.*;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GetEmployeeDataModelTest
{
  private GetEmployeeDataModel test;
  private EmployeeModelManager manager;

  private Doctor dummyDoctor;
  private Nurse dummyNurse;

  @BeforeEach public void setUp()
  {
    GetEmployeeDataClient client = new GetEmployeeDataClientRMI();
    test = new GetEmployeeDataModelImpl(client);
    createDummyData();
  }

  @AfterEach public void undo()
  {
    manager.removeDoctor(dummyDoctor);
    manager.removeNurse(dummyNurse);
  }

  @Test public void getListOfAllDoctors()
  {
    ArrayList<Doctor> listOfAllDoctors = test.getListOfAllDoctors();
    assertTrue(listOfAllDoctors.size() > 0);
  }

  @Test public void getListOfAllNurses()
  {
    ArrayList<Nurse> listOfAllNurses = test.getListOfAllNurses();
    assertTrue(listOfAllNurses.size() > 0);
  }

  @Test public void getDoctorBySSN()
  {
    long dummyDoctorSsn = dummyDoctor.getSsn();
    Doctor doctorBySSN = test.getDoctorBySSN(dummyDoctorSsn);

    assertEquals(dummyDoctorSsn, doctorBySSN.getSsn());
  }

  @Test public void getNurseBySSN()
  {
    long dummyNurseSsn = dummyNurse.getSsn();
    Nurse nurseBySSN = test.getNurseBySSN(dummyNurseSsn);

    assertEquals(dummyNurseSsn, nurseBySSN.getSsn());
  }

  private void createDummyData()
  {
    EmployeeClientManager client = new EmployeeClientRMI();
    manager = new EmployeeModelManagerImpl(client);

    dummyDoctor = new Doctor("Test", "", "", 1010101010L, null,
        new Address("", "", "", ""), "", "", "", "", new Date(1239781), "", "",
        new Ward("Examination", 100), "123@123.123", "123ABcd123");
    manager.addDoctor(dummyDoctor);

    dummyNurse = new Nurse(1010101010L, 0, "Test", "", "", new Date(12312),
        new Address("", "", "", ""), "", "", "", "", new Date(1234), "", "",
        "123@123.com", "123Abcd123");
    manager.addNurse(dummyNurse);
  }
}