package server.model.doctor;

import server.database.doctor.TreatAndUpdateDBAccessDoctor;
import server.database.doctor.TreatAndUpdateDBAccessDoctorImpl;
import server.model.shared.ServerPoolModelImpl;
import shared.Diagnosis;
import shared.Doctor;
import shared.Patient;
import shared.Treatment;
import shared.callback.UpdateType;

import java.util.ArrayList;

public class TreatAndUpdateServerModelDoctorImpl
    implements TreatAndUpdateServerModelDoctor
{
  private TreatAndUpdateDBAccessDoctor dbAccessDoctor;

  public TreatAndUpdateServerModelDoctorImpl()
  {
    dbAccessDoctor = new TreatAndUpdateDBAccessDoctorImpl();
  }

  @Override public void addDiagnosisToPatient(Patient patient,
      Diagnosis diagnosis)
  {
    dbAccessDoctor.addDiagnosisToPatient(patient, diagnosis);
    ServerPoolModelImpl.getInstance().update(UpdateType.DIAGNOSIS);
  }

  @Override public void treatPatient(Patient patient, Diagnosis diagnosis,
      Doctor doctor, Treatment treatment)
  {
    dbAccessDoctor.treatPatient(patient, diagnosis, doctor, treatment);
    ServerPoolModelImpl.getInstance().update(UpdateType.TREATMENT);
  }

  @Override public ArrayList<Diagnosis> getAllDiseasesOfPatient(Patient patient)
  {
    return dbAccessDoctor.getAllDiagnosisOfPatient(patient);
  }

  @Override public void editDiagnosis(Diagnosis diagnosis)

  {
    dbAccessDoctor.editDiagnosis(diagnosis);
    ServerPoolModelImpl.getInstance().update(UpdateType.DIAGNOSIS);
  }

  @Override public ArrayList<Treatment> getAllTreatmentsOfPatient(
      Patient patient, Doctor doctor)
  {
    return dbAccessDoctor.getAllTreatmentsOfPatient(patient, doctor);
  }
}
