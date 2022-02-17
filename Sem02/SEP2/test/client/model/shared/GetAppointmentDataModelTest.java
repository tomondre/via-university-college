package client.model.shared;

import client.model.manager.EmployeeModelManager;
import client.model.manager.EmployeeModelManagerImpl;
import client.model.nurse.AppointmentsModelNurse;
import client.model.nurse.AppointmentsModelNurseImpl;
import client.model.nurse.PatientModelNurse;
import client.model.nurse.PatientModelNurseImpl;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetAppointmentDataModelTest
{
  private GetAppointmentDataModel test;
  private EmployeeModelManager manager;
  private PatientModelNurse nurse;
  private AppointmentsModelNurse appointmentsModelNurse;


  private Doctor dummyDoctor;
  private Patient dummyPatient;
  private Appointment dummyAppointment;

  @BeforeEach public void setUp()
  {
    GetAppointmentDataClient dataClient = new GetAppointmentDataClientRMI();
    test = new GetAppointmentDataModelImpl(dataClient);
    addDummyAppointment();
  }

  @AfterEach private void undo()
  {
    manager.removeDoctor(dummyDoctor);
    nurse.removePatient(dummyPatient);

    appointmentsModelNurse.removeAppointment(dummyAppointment);
  }

  @Test public void getAllAppointments()
  {
    appointmentsModelNurse.createAppointment(dummyAppointment);

    ArrayList<Appointment> allAppointments = test.getAllAppointments();

   assertTrue(containsDummyAppointment(allAppointments));
  }

  @Test public void getAppointmentsForDoctor()
  {
    appointmentsModelNurse.createAppointment(dummyAppointment);

    ArrayList<Appointment> appointmentsForDoctor = test
        .getAppointmentsForDoctor(dummyDoctor);

    assertTrue(containsDummyAppointment(appointmentsForDoctor));
  }

  private void addDummyAppointment()
  {
    AppointmentsClientNurse c1 = new AppointmentsClientNurseRMI();
    appointmentsModelNurse = new AppointmentsModelNurseImpl(c1);

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

    dummyAppointment = new Appointment(Timestamp.valueOf("2021-12-2 14:30:00"),
        Timestamp.valueOf("2021-12-2 15:30:00"), dummyDoctor.getSsn(),
        dummyPatient.getSsn());
  }

  private boolean containsDummyAppointment(ArrayList<Appointment> appointments)
  {
    for (Appointment appointment : appointments)
    {
      if (appointment.equals(dummyAppointment))
      {
        return true;
      }
    }
    return false;
  }
}