package client.view_models.doctor;

import client.model.shared.CallBackModel;
import client.model.shared.GetAppointmentDataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Appointment;
import shared.CurrentUser;
import shared.Doctor;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class AppointmentsViewModel
{
  private ObservableList<Appointment> appointments;

  private GetAppointmentDataModel getAppointmentDataModel;

  public AppointmentsViewModel(Object getAppointmentDataModel, Object callBack)
  {
    this.getAppointmentDataModel = (GetAppointmentDataModel) getAppointmentDataModel;
    ((CallBackModel) callBack)
        .addPropertyChangeListener(UpdateType.APPOINTMENT.toString(),
            this::appointmentsUpdated);
    appointments = FXCollections.observableArrayList();
  }

  private void appointmentsUpdated(PropertyChangeEvent propertyChangeEvent)
  {
    if (CurrentUser.getInstance().isDoctor())
    {
      loadAppointments();
    }
  }

  public void loadAppointments()
  {
    CurrentUser user = CurrentUser.getInstance();
    if (user.isDoctor())
    {
      Doctor currentDoctorUser = (Doctor) user.getCurrentUser();
      List<Appointment> appointmentsList = getAppointmentDataModel
          .getAppointmentsForDoctor(currentDoctorUser);
      appointments.setAll(appointmentsList);
    }
  }

  public ObservableList<Appointment> getAppointments()
  {
    return appointments;
  }

}
