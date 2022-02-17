package client.view_models.doctor;

import client.model.doctor.TreatAndUpdateModelDoctor;
import client.model.shared.CallBackModel;
import client.shared.SelectionModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.*;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;

public class TreatPatientViewModel
{
  private ObservableList<Diagnosis> diagnoses;
  private ObservableList<Treatment> treatments;
  private StringProperty description;
  private Patient patient;

  private TreatAndUpdateModelDoctor treatAndUpdateModelDoctor;

  public TreatPatientViewModel(Object treatAndUpdateModelDoctor,
      Object callBackModel)
  {
    CallBackModel callModel = (CallBackModel) callBackModel;
    callModel.addPropertyChangeListener(UpdateType.TREATMENT.toString(),
        this::treatmentUpdated);
    callModel.addPropertyChangeListener(UpdateType.DIAGNOSIS.toString(),
        this::diagnosisUpdated);

    this.treatAndUpdateModelDoctor = (TreatAndUpdateModelDoctor) treatAndUpdateModelDoctor;
    description = new SimpleStringProperty();

    diagnoses = FXCollections.observableArrayList();
    treatments = FXCollections.observableArrayList();
  }

  private void diagnosisUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isDoctor())
    {
      loadDiagnoses();
    }
  }

  private void treatmentUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isDoctor())
    {
      loadTreatments();
    }
  }

  public void loadDiagnoses()
  {
    diagnoses
        .setAll(treatAndUpdateModelDoctor.getAllDiagnosisOfPatient(patient));
  }

  public void loadTreatments()
  {
    treatments.setAll(treatAndUpdateModelDoctor
        .getAllTreatmentsOfPatient(patient,
            (Doctor) CurrentUser.getInstance().getCurrentUser()));
  }

  public ObservableList<Diagnosis> getDiagnoses()
  {
    return diagnoses;
  }

  public ObservableList<Treatment> getTreatments()
  {
    return treatments;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }

  public void loadSelectedPatient()
  {
    patient = (Patient) SelectionModel.getInstance().get();
  }

  public void addTreatment(String medication, Diagnosis selectedDiagnosis)
      throws InvalidParameterException
  {
    if (validateInput(medication, selectedDiagnosis))
    {
      throw new InvalidParameterException("Please fill in all the data.");
    }
    Treatment treatment = new Treatment(medication, description.get());
    treatAndUpdateModelDoctor.treatPatient(patient, selectedDiagnosis,
        (Doctor) CurrentUser.getInstance().getCurrentUser(), treatment);
  }

  private boolean validateInput(String medication, Diagnosis selectedDiagnosis)
  {
    return medication == null || selectedDiagnosis == null || description.get() == null || description.get().isBlank() || patient == null;
  }
}
