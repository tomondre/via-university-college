package client.view_models.nurse;

import client.model.nurse.AppointmentsModelNurse;
import client.model.shared.CallBackModel;
import client.model.shared.GetEmployeeDataModel;
import client.model.shared.GetPatientDataModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.*;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.time.LocalDate;

public class MakeAppointmentViewModel
{
  private ObservableList<Patient> allPatients;
  private ObservableList<Doctor> availableDoctors;

  private ObjectProperty<LocalDate> appointmentDate;
  private StringProperty appointmentTime;

  private GetEmployeeDataModel getEmployeeDataModel;
  private AppointmentsModelNurse appointmentsModelNurse;
  private GetPatientDataModel getPatientDataModel;

  public MakeAppointmentViewModel(Object appointmentsModelNurse,
      Object getEmployeeDataModel, Object getPatientDataModel,
      Object callBackModel)
  {
    CallBackModel callBack = (CallBackModel) callBackModel;
    callBack.addPropertyChangeListener(UpdateType.PATIENT.toString(),
        this::patientUpdated);
    callBack.addPropertyChangeListener(UpdateType.DOCTOR.toString(),
        this::doctorUpdated);

    this.getEmployeeDataModel = (GetEmployeeDataModel) getEmployeeDataModel;
    this.getPatientDataModel = (GetPatientDataModel) getPatientDataModel;
    this.appointmentsModelNurse = (AppointmentsModelNurse) appointmentsModelNurse;

    allPatients = FXCollections.observableArrayList();
    availableDoctors = FXCollections.observableArrayList();
    appointmentDate = new SimpleObjectProperty<>();
    appointmentTime = new SimpleStringProperty("hh:mm:ss");
  }

  private void doctorUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isNurse())
    {
      loadDoctorData();
    }
  }

  private void patientUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isNurse())
    {
      loadPatientData();
    }
  }

  public ObservableList<Patient> getAllPatients()
  {
    return allPatients;
  }

  public ObservableList<Doctor> getAvailableDoctors()
  {
    return availableDoctors;
  }

  public ObjectProperty<LocalDate> appointmentDateProperty()
  {
    return appointmentDate;
  }

  public StringProperty appointmentTimeProperty()
  {
    return appointmentTime;
  }

  public void createAppointment(Patient patient, Doctor doctor)
      throws InvalidParameterException
  {
    if (patient == null || doctor == null)
    {
      throw new InvalidParameterException(
          "Please select patient and doctor from the tables in order to create appointment");
    }
    else if (appointmentTime.get() == null || appointmentDate.get() == null)
    {
      throw new InvalidParameterException(
          "Please select date and time for the appointment.");
    }
    else if (!Validator.isValidTelTimeFormat(appointmentTime.get()))
    {
      throw new InvalidParameterException(
          "Invalid time. Please use \"hh:mm:ss\" format and time between 00:00:00 and 23:59:59.");
    }
    else if (!Validator.isAppointmentDateValid(appointmentDate.get()))
    {
      throw new InvalidParameterException(
          "Invalid date. Please select correct date.");
    }

    Timestamp timestamp = Timestamp.valueOf(
        appointmentDate.get().toString() + " " + appointmentTime.get());
    Timestamp from = new Timestamp(timestamp.getTime());
    timestamp.setTime(timestamp.getTime() + 3600000);

    Appointment appointment = new Appointment(from, timestamp, doctor.getSsn(),
        patient.getSsn());
    appointmentsModelNurse.createAppointment(appointment);
  }

  public void loadPatientData()
  {
    allPatients.clear();
    allPatients.setAll(getPatientDataModel.getAllPatients());
  }

  public void loadDoctorData()
  {
    availableDoctors.clear();
    availableDoctors.setAll(getEmployeeDataModel.getListOfAllDoctors());
  }

  public void clearAppointment()
  {
    appointmentDate.set(null);
    appointmentTime.set("");
  }
}
