package server.model.nurse;

import server.database.nurse.PatientDBAccessNurse;
import server.database.nurse.PatientDBAccessNurseImpl;
import server.model.shared.ServerPoolModelImpl;
import shared.Patient;
import shared.callback.UpdateType;

public class PatientServerModelNurseImpl implements PatientServerModelNurse
{
    private PatientDBAccessNurse dbAccessNurse;

    public PatientServerModelNurseImpl()
    {
        dbAccessNurse = new PatientDBAccessNurseImpl();
    }

    @Override
    public void addPatient(Patient patient)
    {
        dbAccessNurse.addPatient(patient);
        ServerPoolModelImpl.getInstance().update(UpdateType.PATIENT);
    }

    @Override
    public void editPatient(Patient patient)
    {
        dbAccessNurse.editPatient(patient);
        ServerPoolModelImpl.getInstance().update(UpdateType.PATIENT);
    }

    @Override
    public void removePatient(Patient patient)
    {
        dbAccessNurse.removePatient(patient);
        ServerPoolModelImpl.getInstance().update(UpdateType.PATIENT);
    }
}
