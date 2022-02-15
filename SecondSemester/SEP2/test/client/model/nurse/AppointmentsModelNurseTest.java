package client.model.nurse;

import client.model.manager.EmployeeModelManager;
import client.model.manager.EmployeeModelManagerImpl;
import client.model.shared.GetAppointmentDataModel;
import client.model.shared.GetAppointmentDataModelImpl;
import client.networking.manager.EmployeeClientManager;
import client.networking.manager.EmployeeClientRMI;
import client.networking.nurse.AppointmentsClientNurse;
import client.networking.nurse.AppointmentsClientNurseRMI;
import client.networking.nurse.PatientClientNurse;
import client.networking.nurse.PatientClientNurseRMI;
import client.networking.shared.GetAppointmentDataClient;
import client.networking.shared.GetAppointmentDataClientRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppointmentsModelNurseTest
{
  private AppointmentsModelNurse test;
  private GetAppointmentDataModel resultCheck;
  private EmployeeModelManager manager;
  private PatientModelNurse nurse;

  private Doctor dummyDoctor;
  private Patient dummyPatient;
  private Appointment dummyAppointment;

  @BeforeEach public void setUp()
  {
    AppointmentsClientNurse client = new AppointmentsClientNurseRMI();
    test = new AppointmentsModelNurseImpl(client);

    GetAppointmentDataClient appClient = new GetAppointmentDataClientRMI();
    resultCheck = new GetAppointmentDataModelImpl(appClient);

    addDummyAppointment();

  }

  @AfterEach private void undo()
  {
    manager.removeDoctor(dummyDoctor);
    nurse.removePatient(dummyPatient);

    test.removeAppointment(dummyAppointment);
  }

  @Test public void createAppointment()
  {
    test.createAppointment(dummyAppointment);

    assertTrue(isFoundInDB());
  }

  @Test public void removeAppointment()
  {
    test.removeAppointment(dummyAppointment);

    assertFalse(isFoundInDB());
  }

  private boolean isFoundInDB()
  {
    ArrayList<Appointment> allAppointments = resultCheck.getAllAppointments();
    for (Appointment a : allAppointments)
    {
      if (a.getDoctorSSN() == dummyAppointment.getDoctorSSN()
          && a.getPatientSSN() == dummyAppointment.getPatientSSN() && a
          .getFrom().equals(dummyAppointment.getFrom()) && a.getTo()
          .equals(dummyAppointment.getTo()))
      {
        return true;
      }
    }
    return false;
  }

  private void addDummyAppointment()
  {
    EmployeeClientManager client = new EmployeeClientRMI();
    manager = new EmployeeModelManagerImpl(client);

    PatientClientNurse c = new PatientClientNurseRMI();
    nurse = new PatientModelNurseImpl(c);

    dummyDoctor = new Doctor("Test", "", "", 1010101010L, null,
        new Address("", "", "", ""), "", "", "", "", new Date(1239781), "", "",
        new Ward("Examination", 100), "123@123.123", "123ABcd123");
    manager.addDoctor(dummyDoctor);

    dummyPatient = new Patient("Test", "", "", 1010101010L, new Date(123456),
        new Address("", "", "", ""), "", "", "", "", "B+", "", 'M');
    nurse.addPatient(dummyPatient);

    dummyAppointment = new Appointment(new Timestamp(10000000000L),
        new Timestamp(10000003600L), dummyDoctor.getSsn(),
        dummyPatient.getSsn());
  }
}