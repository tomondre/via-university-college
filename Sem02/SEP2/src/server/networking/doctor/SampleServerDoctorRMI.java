package server.networking.doctor;

import server.model.doctor.SampleServerModelDoctor;
import server.model.doctor.SampleServerModelDoctorImpl;
import shared.Patient;
import shared.Sample;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SampleServerDoctorRMI implements SampleServerDoctor
{
    private SampleServerModelDoctor modelDoctor;

    public SampleServerDoctorRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        modelDoctor = new SampleServerModelDoctorImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("SampleServerDoctor", this);
        System.out.println("SampleServerDoctor is running!");
    }

    @Override
    public synchronized ArrayList<Sample> getAllSamples()
    {
        return modelDoctor.getAllSamples();
    }

    @Override
    public synchronized void createSample(Sample sample)
    {
        modelDoctor.createSample(sample);
    }

    @Override
    public synchronized void editSample(Sample sample)
    {
        modelDoctor.editSample(sample);
    }

    @Override
    public synchronized Sample getSampleById(int id)
    {
        return modelDoctor.getSampleById(id);
    }

    @Override
    public synchronized ArrayList<Sample> getAllPatientSamples(Patient patient)
    {
        return modelDoctor.getAllPatientSamples(patient);
    }
}
