package server.model.manager;

import server.database.manager.EmployeeDBAccessImpl;
import server.database.manager.EmployeeDBAccessManager;
import server.model.shared.ServerPoolModelImpl;
import shared.Doctor;
import shared.Nurse;
import shared.callback.UpdateType;

import java.util.ArrayList;

public class EmployeeServerModelManagerImpl implements EmployeeServerModelManager
{
    private EmployeeDBAccessManager dbAccessManager;

    public EmployeeServerModelManagerImpl()
    {
        dbAccessManager = new EmployeeDBAccessImpl();
    }

    @Override
    public String addDoctor(Doctor doctor)
    {
        dbAccessManager.addDoctor(doctor);
        ServerPoolModelImpl.getInstance().update(UpdateType.DOCTOR);
        return null;
    }

    @Override
    public String addNurse(Nurse nurse)
    {
        dbAccessManager.addNurse(nurse);
        ServerPoolModelImpl.getInstance().update(UpdateType.NURSE);
        return null;
    }

    @Override
    public String editDoctor(Doctor doctor)
    {
        dbAccessManager.editDoctor(doctor);
        ServerPoolModelImpl.getInstance().update(UpdateType.DOCTOR);
        return null;
    }

    @Override
    public String editNurse(Nurse nurse)
    {
        dbAccessManager.editNurse(nurse);
        ServerPoolModelImpl.getInstance().update(UpdateType.NURSE);
        return null ;
    }

    @Override
    public String removeDoctor(Doctor doctor)
    {
        dbAccessManager.removeDoctor(doctor);
        ServerPoolModelImpl.getInstance().update(UpdateType.DOCTOR);
        return null;
    }

    @Override
    public String removeNurse(Nurse nurse)
    {
        dbAccessManager.removeNurse(nurse);
        ServerPoolModelImpl.getInstance().update(UpdateType.NURSE);
        return null;
    }
}
