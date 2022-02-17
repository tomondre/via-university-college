package server.model.nurse;

import server.database.nurse.AppointmentsDBAccessNurse;
import server.database.nurse.AppointmentsDBAccessNurseImpl;
import server.model.shared.ServerPoolModelImpl;
import shared.Appointment;
import shared.Patient;
import shared.callback.UpdateType;

import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;

public class AppointmentsServerModelNurseImpl implements AppointmentsServerModelNurse
{
    private AppointmentsDBAccessNurse dbAccessNurse;

    public AppointmentsServerModelNurseImpl()
    {
        dbAccessNurse = new AppointmentsDBAccessNurseImpl();
    }


    @Override
    public void createAppointment(Appointment appointment)
    {
        dbAccessNurse.createAppointment(appointment);
        ServerPoolModelImpl.getInstance().update(UpdateType.APPOINTMENT);
    }

    @Override
    public void removeAppointment(Appointment appointment)
    {
        dbAccessNurse.removeAppointment(appointment);
        ServerPoolModelImpl.getInstance().update(UpdateType.APPOINTMENT);
    }
}
