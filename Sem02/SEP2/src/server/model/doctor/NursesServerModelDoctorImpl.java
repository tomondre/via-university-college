package server.model.doctor;

import server.database.doctor.NursesDBAccessDoctor;
import server.database.doctor.NursesDBAccessDoctorImpl;
import server.model.shared.ServerPoolModelImpl;
import server.networking.shared.ServerPool;
import shared.Doctor;
import shared.Nurse;
import shared.callback.UpdateType;

import java.util.ArrayList;

public class NursesServerModelDoctorImpl implements NursesServerModelDoctor
{
    private NursesDBAccessDoctor dbAccessDoctor;

    public NursesServerModelDoctorImpl()
    {
        dbAccessDoctor = new NursesDBAccessDoctorImpl();
    }

    @Override
    public ArrayList<Nurse> getAllAvailableNurses()
    {
        return dbAccessDoctor.getAllAvailableNurses();
    }

    @Override
    public void assignNurse(Nurse nurse, Doctor doctor)
    {
        dbAccessDoctor.assignNurse(nurse, doctor);
        ServerPoolModelImpl.getInstance().update(UpdateType.NURSE);
    }

    @Override
    public ArrayList<Nurse> getAllNursesAssignedToMe(Doctor doctor)
    {
        return dbAccessDoctor.getAllNursesAssignedToMe(doctor);
    }
}
