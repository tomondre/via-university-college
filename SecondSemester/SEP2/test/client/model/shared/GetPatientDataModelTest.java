package client.model.shared;

import client.model.doctor.SampleModelDoctor;
import client.model.doctor.SampleModelDoctorImpl;
import client.model.nurse.PatientModelNurse;
import client.model.nurse.PatientModelNurseImpl;
import client.networking.doctor.SampleClientDoctor;
import client.networking.doctor.SampleClientDoctorRMI;
import client.networking.nurse.PatientClientNurse;
import client.networking.nurse.PatientClientNurseRMI;
import client.networking.shared.GetPatientDataClient;
import client.networking.shared.GetPatientDataClientRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Address;
import shared.Patient;
import shared.Sample;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GetPatientDataModelTest
{
  private GetPatientDataModel test;
  private PatientModelNurse nurse;
  private SampleModelDoctor doctor;

  private Patient dummyPatient;
  private Sample dummySample;

  @BeforeEach public void setUp()
  {
    GetPatientDataClient client = new GetPatientDataClientRMI();
    test = new GetPatientDataModelImpl(client);

    createDummyData();
  }

  @Test public void getAllPatients()
  {
    ArrayList<Patient> allPatients = test.getAllPatients();
    assertTrue(allPatients.size() > 0);
  }

  @Test public void getPatientBySSN()
  {
    Patient patientBySSN = test.getPatientBySSN(dummyPatient.getSsn());
    assertNotNull(patientBySSN);
  }

  @Test public void getPatientSamples()
  {
    ArrayList<Sample> patientSamples = test
        .getPatientSamples(dummyPatient.getSsn());

    assertTrue(patientSamples.size() > 0);
  }

  public void createDummyData()
  {
    PatientClientNurse c = new PatientClientNurseRMI();
    nurse = new PatientModelNurseImpl(c);

    SampleClientDoctor client = new SampleClientDoctorRMI();
    doctor = new SampleModelDoctorImpl(client);

    dummyPatient = new Patient("Test", "", "", 1010101010L, new Date(123456),
        new Address("", "", "", ""), "", "", "", "", "B+", "", 'M');
    nurse.addPatient(dummyPatient);

    dummySample = new Sample("DNA", "Test", 2, new Date(1232480L),
        dummyPatient.getSsn(), 4);

    doctor.createSample(dummySample);
  }

  @AfterEach public void undo()
  {
    nurse.removePatient(dummyPatient);
  }

}