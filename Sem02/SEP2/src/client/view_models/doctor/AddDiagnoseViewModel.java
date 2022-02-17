package client.view_models.doctor;

import client.model.doctor.TreatAndUpdateModelDoctor;
import client.shared.SelectionModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Diagnosis;
import shared.Patient;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.time.LocalDate;

/**
 * View model responsible for
 */
public class AddDiagnoseViewModel
{
  private StringProperty name;
  private StringProperty description;
  private StringProperty severityLevel;
  private ObservableList<String> severityLevels;
  private ObjectProperty<LocalDate> startDate;
  private ObjectProperty<LocalDate> endDate;

  private TreatAndUpdateModelDoctor treatAndUpdateModelDoctor;
  private Patient patient;

  public AddDiagnoseViewModel(Object treatAndUpdateModelDoctor)
  {
    this.treatAndUpdateModelDoctor = (TreatAndUpdateModelDoctor) treatAndUpdateModelDoctor;
    name = new SimpleStringProperty();
    description = new SimpleStringProperty();
    severityLevel = new SimpleStringProperty();
    startDate = new SimpleObjectProperty<>();
    endDate = new SimpleObjectProperty<>();
    severityLevels = FXCollections.observableArrayList("1", "2", "3", "4", "5");
  }

  public StringProperty nameProperty()
  {
    return name;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }

  public StringProperty severityLevelProperty()
  {
    return severityLevel;
  }

  public ObjectProperty<LocalDate> startDateProperty()
  {
    return startDate;
  }

  public ObjectProperty<LocalDate> endDateProperty()
  {
    return endDate;
  }

  public ObservableList<String> getSeverityLevels()
  {
    return severityLevels;
  }

  public void loadSelectedPatient()
  {
    patient = (Patient) SelectionModel.getInstance().get();
  }

  public void clear()
  {
    name.set("");
    description.set("");
    severityLevel.set("");
    startDate.set(null);
    endDate.set(null);
    severityLevel.set("");
  }

  public void save() throws InvalidParameterException
  {
    if (verifyInputs())
    {
      throw new InvalidParameterException(
          "Please fill in all the fields to create diagnosis.");
    }
    if (!isDateValid())
    {
      throw new InvalidParameterException(
          "Please select correct diagnosis dates.");
    }
    Diagnosis diagnosis = new Diagnosis(name.get(),
        Integer.parseInt(severityLevel.get()), description.get(),
        Date.valueOf(startDate.get()));

    treatAndUpdateModelDoctor.addDiagnosisToPatient(patient, diagnosis);
    clear();
  }

  private boolean verifyInputs()
  {
    return name.get() == null || severityLevel.get() == null || description.get() == null;
  }

  private boolean isDateValid()
  {
    if (startDate.get() == null)
    {
      return false;
    }
    if (endDate.get() != null)
    {
      if (!(startDate.get().isBefore(endDate.get())))
      {
        return false;
      }
    }
    return startDate.get().isAfter(LocalDate.now().minusYears(5));
  }
}
