package client.model.doctor;

import client.model.nurse.PatientModelNurse;
import client.model.nurse.PatientModelNurseImpl;
import client.networking.doctor.SampleClientDoctor;
import client.networking.doctor.SampleClientDoctorRMI;
import client.networking.nurse.PatientClientNurse;
import client.networking.nurse.PatientClientNurseRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Address;
import shared.Patient;
import shared.Sample;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SampleModelDoctorTest
{
  private SampleModelDoctor test;
  private Sample dummySample;

  private PatientModelNurse nurse;
  private Patient dummyPatient;

  @BeforeEach public void setUp()
  {
    SampleClientDoctor client = new SampleClientDoctorRMI();
    test = new SampleModelDoctorImpl(client);

    createDummySample();
  }

  @AfterEach private void removeDummySample()
  {
    //Also removes the Sample assigned to removed patient - Database constraint
    nurse.removePatient(dummyPatient);
  }

  @Test public void getAllSamples()
  {
    test.createSample(dummySample);

    ArrayList<Sample> allSamples = test.getAllSamples();
    assertNotNull(allSamples);
  }

  @Test public void editSample()
  {
    test.createSample(dummySample);

    Sample dummySampleFromDB = getSampleFromDB(dummySample);
    dummySampleFromDB.setResult("Testing");
    test.editSample(dummySampleFromDB);

    Sample sampleByID = getSampleFromDB(dummySampleFromDB);
    assertEquals(sampleByID.getResult(), dummySampleFromDB.getResult());
  }

  @Test public void getSampleByID()
  {
    test.createSample(dummySample);
    int sample_id = getSampleFromDB(dummySample).getSample_id();

    Sample sampleByID = test.getSampleByID(sample_id);

    assertEquals(sampleByID, dummySample);
  }

  @Test public void createSample()
  {
    test.createSample(dummySample);

    Sample dummySampleFromDB = getSampleFromDB(dummySample);

    assertNotNull(dummySampleFromDB);
  }

  private void createDummySample()
  {
    PatientClientNurse client = new PatientClientNurseRMI();
    nurse = new PatientModelNurseImpl(client);

    dummyPatient = new Patient("Test", "", "", 1010101010L, new Date(123456),
        new Address("", "", "", ""), "", "", "", "", "B+", "", 'M');
    nurse.addPatient(dummyPatient);

    dummySample = new Sample("DNA", "Test", 2, new Date(1232480L),
        dummyPatient.getSsn(), 4);
  }

  private Sample getSampleFromDB(Sample sample)
  {
    for (Sample s: test.getAllSamples())
    {
      if (sample.equals(s))
      {
        return s;
      }
    }
    return null;
  }

}