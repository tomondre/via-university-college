package client.model.manager;

import client.model.shared.GetEmployeeDataModel;
import client.model.shared.GetEmployeeDataModelImpl;
import client.networking.manager.EmployeeClientManager;
import client.networking.manager.EmployeeClientRMI;
import client.networking.shared.GetEmployeeDataClient;
import client.networking.shared.GetEmployeeDataClientRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Address;
import shared.Doctor;
import shared.Nurse;
import shared.Ward;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EmployeeModelManagerTest
{
  private EmployeeModelManager test;
  private Doctor dummyDoctor;
  private GetEmployeeDataModel resultCheck;
  private Nurse dummyNurse;

  @BeforeEach public void setup()
  {
    EmployeeClientManager client = new EmployeeClientRMI();
    test = new EmployeeModelManagerImpl(client);

    GetEmployeeDataClient resultClient = new GetEmployeeDataClientRMI();
    resultCheck = new GetEmployeeDataModelImpl(resultClient);

    createDummyData();
  }

  @AfterEach public void undo()
  {
    test.removeDoctor(dummyDoctor);
    test.removeNurse(dummyNurse);
  }

  @Test public void addDoctor()
  {
    test.addDoctor(dummyDoctor);

    Doctor result = resultCheck.getDoctorBySSN(dummyDoctor.getSsn());
    assertEquals(dummyDoctor.getSsn(), result.getSsn());
  }

  @Test public void addNurse()
  {
    test.addNurse(dummyNurse);

    Nurse result = resultCheck.getNurseBySSN(dummyNurse.getSsn());
    assertEquals(dummyNurse.getSsn(), result.getSsn());
  }

  @Test public void editDoctor()
  {
    test.addDoctor(dummyDoctor);

    Doctor doctorBySSN = resultCheck.getDoctorBySSN(dummyDoctor.getSsn());
    doctorBySSN.setSpecialization("Spec");
    doctorBySSN.setFirstName("FN");
    doctorBySSN.setMiddleName("SN");
    doctorBySSN.setLastName("LN");
    doctorBySSN.setAddress(new Address("TS", "TN", "TZ", "TC"));
    doctorBySSN.setEducation("Education");
    doctorBySSN.setContactMiddleName("CM");
    doctorBySSN.setContactFirstName("CF");
    doctorBySSN.setContactLastName("CL");
    doctorBySSN.setContactPhoneNumber("000000");
    doctorBySSN.setEmail("dummy@dummy.com");
    doctorBySSN.setPassword("Dummy12345");

    test.editDoctor(doctorBySSN);
    Doctor result = resultCheck.getDoctorBySSN(dummyDoctor.getSsn());

    assertEquals("Spec", result.getSpecialization());
    assertEquals("FN", result.getFirstName());
    assertEquals("SN", result.getMiddleName());
    assertEquals("LN", result.getLastName());
    assertEquals("TS", result.getAddress().getStreet());
    assertEquals("TN", result.getAddress().getNumber());
    assertEquals("TZ", result.getAddress().getZipcode());
    assertEquals("TC", result.getAddress().getCity());
    assertEquals("Education", result.getEducation());
    assertEquals("CM", result.getContactMiddleName());
    assertEquals("CF", result.getContactFirstName());
    assertEquals("CL", result.getContactLastName());
    assertEquals("000000", result.getContactPhoneNumber());
    assertEquals("dummy@dummy.com", result.getEmail());
    assertEquals("Dummy12345", result.getPassword());
  }

  @Test public void editNurse()
  {
    test.addNurse(dummyNurse);

    Nurse nurseBySSN = resultCheck.getNurseBySSN(dummyNurse.getSsn());
    nurseBySSN.setExperience("Spec");
    nurseBySSN.setFirstName("FN");
    nurseBySSN.setMiddleName("SN");
    nurseBySSN.setLastName("LN");
    nurseBySSN.setAddress(new Address("TS", "TN", "TZ", "TC"));
    nurseBySSN.setEducation("Education");
    nurseBySSN.setContactMiddleName("CM");
    nurseBySSN.setContactFirstName("CF");
    nurseBySSN.setContactLastName("CL");
    nurseBySSN.setContactPhoneNumber("000000");
    nurseBySSN.setEmail("dummy@dummy.com");
    nurseBySSN.setPassword("Dummy12345");

    test.editNurse(nurseBySSN);
    Nurse result = resultCheck.getNurseBySSN(nurseBySSN.getSsn());

    assertEquals("Spec", result.getExperience());
    assertEquals("FN", result.getFirstName());
    assertEquals("SN", result.getMiddleName());
    assertEquals("LN", result.getLastName());
    assertEquals("TS", result.getAddress().getStreet());
    assertEquals("TN", result.getAddress().getNumber());
    assertEquals("TZ", result.getAddress().getZipcode());
    assertEquals("TC", result.getAddress().getCity());
    assertEquals("Education", result.getEducation());
    assertEquals("CM", result.getContactMiddleName());
    assertEquals("CF", result.getContactFirstName());
    assertEquals("CL", result.getContactLastName());
    assertEquals("000000", result.getContactPhoneNumber());
    assertEquals("dummy@dummy.com", result.getEmail());
    assertEquals("Dummy12345", result.getPassword());
  }

  @Test public void removeDoctor()
  {
    test.removeDoctor(dummyDoctor);

    Doctor result = resultCheck.getDoctorBySSN(dummyDoctor.getSsn());
    assertNull(result);
  }

  @Test public void removeNurse()
  {
    test.removeNurse(dummyNurse);

    Nurse result = resultCheck.getNurseBySSN(dummyNurse.getSsn());
    assertNull(result);
  }

  private void createDummyData()
  {
    dummyDoctor = new Doctor("Test", "", "", 1010101010L, null,
        new Address("", "", "", ""), "", "", "", "", new Date(1239781), "", "",
        new Ward("Examination", 100), "123@123.123", "123ABcd123");

    dummyNurse = new Nurse(1010101010L, 0, "Test", "", "", new Date(12312),
        new Address("", "", "", ""), "", "", "", "", new Date(1234), "", "",
        "123@123.com", "123Abcd123");
  }
}