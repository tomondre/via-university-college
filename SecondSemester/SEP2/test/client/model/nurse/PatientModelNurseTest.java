package client.model.nurse;

import client.model.shared.GetPatientDataModel;
import client.model.shared.GetPatientDataModelImpl;
import client.networking.nurse.PatientClientNurse;
import client.networking.nurse.PatientClientNurseRMI;
import client.networking.shared.GetPatientDataClient;
import client.networking.shared.GetPatientDataClientRMI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Address;
import shared.Patient;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientModelNurseTest
{
  private PatientModelNurse test;
  private GetPatientDataModel resultCheck;
  private Patient patient;

  @BeforeEach public void setUp()
  {
    PatientClientNurse client = new PatientClientNurseRMI();
    test = new PatientModelNurseImpl(client);
    patient = new Patient("Test", "", "", 1010101010L, new Date(123456),
        new Address("", "", "", ""), "", "", "", "", "B+", "", 'M');

    GetPatientDataClient dataClient = new GetPatientDataClientRMI();
    resultCheck = new GetPatientDataModelImpl(dataClient);
  }

  @Test public void addPatient()
  {
    test.addPatient(patient);

    Patient patientBySSN = resultCheck.getPatientBySSN(patient.getSsn());
    assertNotEquals(null, patientBySSN);

    removeDummyData();
  }

  @Test public void editPatient()
  {
    addDummyData();

    patient.setMedical_description("Patient.editPatient() test");
    test.editPatient(patient);

    Patient patientBySSN = resultCheck.getPatientBySSN(patient.getSsn());
    assertEquals(patient.getMedical_description(),
        patientBySSN.getMedical_description());

    removeDummyData();
  }

  @Test public void removePatient()
  {
    addDummyData();

    test.removePatient(patient);

    Patient patientBySSN = resultCheck.getPatientBySSN(patient.getSsn());
    assertNull(patientBySSN);
  }

  private void addDummyData()
  {
    test.addPatient(patient);
  }

  private void removeDummyData()
  {
    test.removePatient(patient);
  }
}