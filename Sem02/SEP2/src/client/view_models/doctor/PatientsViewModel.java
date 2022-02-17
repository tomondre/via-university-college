package client.view_models.doctor;

import client.model.doctor.SampleModelDoctor;
import client.model.doctor.TreatAndUpdateModelDoctor;
import client.model.shared.CallBackModel;
import client.model.shared.GetPatientDataModel;
import client.shared.SelectionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.CurrentUser;
import shared.Patient;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;
import java.util.List;

public class PatientsViewModel
{
  private ObservableList<Patient> patients;

  private GetPatientDataModel getPatientDataModel;
  private TreatAndUpdateModelDoctor treatAndUpdateModelDoctor;
  private SampleModelDoctor sampleModelDoctor;

  public PatientsViewModel(Object getPatientDataModel,
      Object treatAndUpdateModelDoctor, Object sampleModelDoctor,
      Object callbackModel)
  {
    ((CallBackModel) callbackModel)
        .addPropertyChangeListener(UpdateType.PATIENT.toString(),
            this::patientUpdated);
    this.getPatientDataModel = (GetPatientDataModel) getPatientDataModel;
    this.treatAndUpdateModelDoctor = (TreatAndUpdateModelDoctor) treatAndUpdateModelDoctor;
    this.sampleModelDoctor = (SampleModelDoctor) sampleModelDoctor;
    patients = FXCollections.observableArrayList();

  }

  private void patientUpdated(PropertyChangeEvent evt)
  {
    if (CurrentUser.getInstance().isDoctor())
    {
      loadPatients();
    }
  }

  public void loadPatients()
  {
    List<Patient> patientList = getPatientDataModel.getAllPatients();
    patients.setAll(patientList);
  }

  public ObservableList<Patient> getPatients()
  {
    return patients;
  }

  public void getAllDiseasesOfPatient(Patient patient)
  {
    treatAndUpdateModelDoctor.getAllDiagnosisOfPatient(patient);
  }

  public void getAllSamples(Patient patient)
  {
    sampleModelDoctor.getAllSamples();
  }

  public void setSelectedPatient(Patient selectedItem)
  {
    SelectionModel.getInstance().set(selectedItem);
  }

  public void isPatientSelected() throws InvalidParameterException
  {
    if (SelectionModel.getInstance().isEmpty())
    {
      throw new InvalidParameterException("Please select patient");
    }
  }
}
