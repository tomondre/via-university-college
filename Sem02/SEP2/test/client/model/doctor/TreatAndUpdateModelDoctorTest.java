package client.model.doctor;

import client.model.manager.EmployeeModelManager;
import client.model.manager.EmployeeModelManagerImpl;
import client.model.nurse.PatientModelNurse;
import client.model.nurse.PatientModelNurseImpl;
import client.networking.doctor.TreatAndUpdateClientDoctor;
import client.networking.doctor.TreatAndUpdateClientDoctorRMI;
import client.networking.manager.EmployeeClientManager;
import client.networking.manager.EmployeeClientRMI;
import client.networking.nurse.PatientClientNurse;
import client.networking.nurse.PatientClientNurseRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.*;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TreatAndUpdateModelDoctorTest
{
  private TreatAndUpdateModelDoctor test;
  private PatientModelNurse nurse;
  private EmployeeModelManager manager;

  private Patient dummyPatient;
  private Diagnosis dummyDiagnosis;
  private Doctor dummyDoctor;
  private Treatment dummyTreatment;

  @BeforeEach public void setup()
  {
    TreatAndUpdateClientDoctor client = new TreatAndUpdateClientDoctorRMI();
    test = new TreatAndUpdateModelDoctorImpl(client);

    createDummyDoctor();
    createDummyPatient();
    createDummyDiagnosis();
  }

  @AfterEach public void undo()
  {
    nurse.removePatient(dummyPatient);
    manager.removeDoctor(dummyDoctor);
  }

  //Tests are depended on passing on each other. Visually new diagnosis can be seen in database.
  @Test public void addDiagnosisToPatient()
  {
    test.addDiagnosisToPatient(dummyPatient, dummyDiagnosis);

    Diagnosis diagnosisFromDB = getDiagnosisFromDB(dummyDiagnosis);
    assertNotNull(diagnosisFromDB);
  }

  @Test public void getAllDiagnosisOfPatient()
  {
    test.addDiagnosisToPatient(dummyPatient, dummyDiagnosis);

    ArrayList<Diagnosis> allDiagnosisOfPatient = test.getAllDiagnosisOfPatient(dummyPatient);

    assertNotEquals(0, allDiagnosisOfPatient.size());
  }

  @Test public void getAllTreatmentsOfPatient()
  {
    createDummyTreatment();

    ArrayList<Treatment> allTreatmentsOfPatient = test.getAllTreatmentsOfPatient(dummyPatient, dummyDoctor);
    assertNotEquals(0, allTreatmentsOfPatient.size());
  }

  @Test public void treatPatient()
    {
      int numberOfTreatmentsBeforeTreating = test.getAllTreatmentsOfPatient(dummyPatient, dummyDoctor).size();

      createDummyTreatment();

      int numberOfTreatmentsAfterTreating = test.getAllTreatmentsOfPatient(dummyPatient, dummyDoctor).size();

      assertNotEquals(numberOfTreatmentsAfterTreating, numberOfTreatmentsBeforeTreating);
    }


    @Test public void editDiagnosis()
    {
      test.addDiagnosisToPatient(dummyPatient, dummyDiagnosis);

      Diagnosis diagnosisFromDB = getDiagnosisFromDB(dummyDiagnosis);
      diagnosisFromDB.setDescription("Editing Description");
      diagnosisFromDB.setName("Edit Name");
      diagnosisFromDB.setSeverityLevel(1);

      test.editDiagnosis(diagnosisFromDB);

      Diagnosis d = getDiagnosisFromDB(diagnosisFromDB);
      assertEquals("Editing Description", d.getDescription());
    }


  private Diagnosis getDiagnosisFromDB(Diagnosis diagnosis)
  {
    ArrayList<Diagnosis> allDiagnosisOfPatient = test
        .getAllDiagnosisOfPatient(dummyPatient);
    for (Diagnosis d : allDiagnosisOfPatient)
    {
      if (d.getName().equals(diagnosis.getName())
          && d.getSeverityLevel() == diagnosis.getSeverityLevel() && d
          .getDescription().equals(diagnosis.getDescription()))
      {
        return d;
      }
    }
    return null;
  }

  private void createDummyTreatment()
  {
    Diagnosis diagnosisWithIdFromDB = getDiagnosisFromDB(dummyDiagnosis);
    dummyTreatment = new Treatment("TestPills", "This is description");
    test.treatPatient(dummyPatient, diagnosisWithIdFromDB, dummyDoctor, dummyTreatment);
  }
  private void createDummyDiagnosis()
  {
    dummyDiagnosis = new Diagnosis("TestDiagnosis", 2, "This is test diagnosis", new Date(999999999L));
  }

  private void createDummyPatient()
  {
    PatientClientNurse c = new PatientClientNurseRMI();
    nurse = new PatientModelNurseImpl(c);

    dummyPatient = new Patient(null, null, null, 1010101010L, null,
        new Address("", "", "", ""), null, null, null, null, "A-", null, 'M');
    nurse.addPatient(dummyPatient);
  }

  private void createDummyDoctor()
  {
    EmployeeClientManager client = new EmployeeClientRMI();
    manager = new EmployeeModelManagerImpl(client);
    dummyDoctor = new Doctor("", "", "", 1010101010L, null, new Address("","","",""), null, null,
        null, null, null, null, null, new Ward("Examination", 100), "test@test.com", "qwer12334A");
    manager.addDoctor(dummyDoctor);
  }
}