package client.view_models.doctor;

import client.model.doctor.SampleModelDoctor;
import client.model.shared.GetPatientDataModel;
import client.shared.SelectionModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Patient;
import shared.Sample;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.time.LocalDate;

public class AddEditSampleViewModel
{
  private StringProperty type;
  private ObjectProperty<LocalDate> deadline;
  private StringProperty priority;
  private StringProperty result;

  private Sample sample;
  private SampleModelDoctor sampleModelDoctor;

  public AddEditSampleViewModel(Object sampleModelDoctor)
  {
    this.sampleModelDoctor = (SampleModelDoctor) sampleModelDoctor;
    type = new SimpleStringProperty();
    deadline = new SimpleObjectProperty<>();
    priority = new SimpleStringProperty();
    result = new SimpleStringProperty();
  }

  public StringProperty typeProperty()
  {
    return type;
  }

  public ObjectProperty<LocalDate> deadlineProperty()
  {
    return deadline;
  }

  public StringProperty priorityProperty()
  {
    return priority;
  }

  public StringProperty resultProperty()
  {
    return result;
  }

  public void loadSelectedSample()
  {
    if (SelectionModel.getInstance().isSample())
    {
      sample = (Sample) SelectionModel.getInstance().get();
      type.set(sample.getType());
      deadline.set(sample.getDeadline().toLocalDate());
      priority.set(String.valueOf(sample.getPriority()));
      result.setValue(sample.getResult());
    }
    else
    {
      clear();
    }
  }

  public void clear()
  {
    sample = null;
    type.set("");
    result.setValue("");
    deadline.set(LocalDate.now());
  }

  public void saveChanges() throws InvalidParameterException
  {
    if (validateInputs())
    {
      throw new InvalidParameterException("Please fill the fields.");
    }

    if (validateDate())
    {
      throw new InvalidParameterException("Please select correct Deadline");
    }
    //Selected Sample before - Editing the sample / Not selected - Adding the sample
    if (sample == null)
    {
      Patient patient = (Patient) SelectionModel.getInstance().get();

      Sample addingSample = new Sample(type.get(), result.get(),
          Integer.parseInt(priority.get()), Date.valueOf(deadline.get()),
          patient.getSsn(), 0);
      sampleModelDoctor.createSample(addingSample);
    }
    else
    {
      Sample editedSample = new Sample(type.get(), result.get(),
          Integer.parseInt(priority.get()), Date.valueOf(deadline.get()),
          sample.getPatient_ssn(), sample.getSample_id());
      sampleModelDoctor.editSample(editedSample);
    }
  }

  private boolean validateDate()
  {
     return deadline.get().isBefore(LocalDate.now());
  }

  private boolean validateInputs()
  {
    if (deadline.get() == null)
      return false;
    return type.get() == null || priority.get() == null;
  }
}
