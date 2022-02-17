package client.view_models.nurse;

import client.model.nurse.AppointmentsModelNurse;
import client.model.shared.CallBackModel;
import client.model.shared.GetAppointmentDataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Appointment;
import shared.CurrentUser;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;
import java.util.List;

public class AllAppointmentsViewModel
{
  private ObservableList<Appointment> allAppointments;
  private GetAppointmentDataModel getAppointmentDataModel;
  private AppointmentsModelNurse appointmentsModelNurse;

  public AllAppointmentsViewModel(Object getAppointmentDataModel,
      Object appointmentsModelNurse, Object callbackClient)
  {
    ((CallBackModel) callbackClient)
        .addPropertyChangeListener(UpdateType.APPOINTMENT.toString(),
            this::appointmentUpdated);

    this.getAppointmentDataModel = (GetAppointmentDataModel) getAppointmentDataModel;
    this.appointmentsModelNurse = (AppointmentsModelNurse) appointmentsModelNurse;
    allAppointments = FXCollections.observableArrayList();
  }

  private void appointmentUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isNurse())
    {
      loadAppointments();
    }
  }

  public void loadAppointments()
  {
    List<Appointment> appointmentList = getAppointmentDataModel
        .getAllAppointments();
    allAppointments.clear();
    allAppointments.addAll(appointmentList);
  }

  public ObservableList<Appointment> getAllAppointments()
  {
    return allAppointments;
  }

  public void removeAnAppointment(Appointment appointment)
      throws InvalidParameterException
  {
    if (appointment == null)
    {
      throw new InvalidParameterException(
          "Please select appointment to remove.");
    }
    appointmentsModelNurse.removeAppointment(appointment);
    loadAppointments();
  }
}
