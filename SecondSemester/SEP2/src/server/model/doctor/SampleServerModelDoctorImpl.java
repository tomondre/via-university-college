package server.model.doctor;

import server.database.doctor.SampleDBAccessDoctor;
import server.database.doctor.SampleDBAccessDoctorImpl;
import server.model.shared.ServerPoolModelImpl;
import shared.Patient;
import shared.Sample;
import shared.callback.UpdateType;

import java.util.ArrayList;

public class SampleServerModelDoctorImpl implements SampleServerModelDoctor
{
    private SampleDBAccessDoctor dbAccessDoctor;

    public SampleServerModelDoctorImpl()
    {
        dbAccessDoctor = new SampleDBAccessDoctorImpl();
    }

    @Override
    public ArrayList<Sample> getAllSamples()
    {
        return dbAccessDoctor.getAllSamples();
    }

    @Override
    public void createSample(Sample sample)
    {
        dbAccessDoctor.createSample(sample);
        ServerPoolModelImpl.getInstance().update(UpdateType.SAMPLE);
    }

    @Override
    public void editSample(Sample sample)
    {
        dbAccessDoctor.editSample(sample);
        ServerPoolModelImpl.getInstance().update(UpdateType.SAMPLE);
    }

    @Override
    public Sample getSampleById(int id)
    {
        return dbAccessDoctor.getSampleById(id);
    }

    @Override public ArrayList<Sample> getAllPatientSamples(Patient patient)
    {
        return dbAccessDoctor.getAllPatientSamples(patient);
    }
}
