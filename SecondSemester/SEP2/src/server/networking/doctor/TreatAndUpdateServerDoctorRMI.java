package server.networking.doctor;

import server.model.doctor.TreatAndUpdateServerModelDoctor;
import server.model.doctor.TreatAndUpdateServerModelDoctorImpl;
import shared.Diagnosis;
import shared.Doctor;
import shared.Patient;
import shared.Treatment;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TreatAndUpdateServerDoctorRMI implements TreatAndUpdateServerDoctor
{
    private TreatAndUpdateServerModelDoctor modelDoctor;

    public TreatAndUpdateServerDoctorRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        modelDoctor = new TreatAndUpdateServerModelDoctorImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("TreatAndUpdateServerDoctor", this);
        System.out.println("TreatAndUpdateServerDoctor is running!");
    }

    @Override
    public synchronized void addDiagnosisToPatient(Patient patient, Diagnosis diagnosis)
    {
        modelDoctor.addDiagnosisToPatient(patient, diagnosis);
    }

    @Override
    public synchronized void treatPatient(Patient patient, Diagnosis diagnosis, Doctor doctor, Treatment treatment)
    {
        modelDoctor.treatPatient(patient, diagnosis, doctor, treatment);
    }

    @Override
    public synchronized ArrayList<Diagnosis> getAllDiseasesOfPatient(Patient patient)
    {
        return modelDoctor.getAllDiseasesOfPatient(patient);
    }

    @Override
    public synchronized void editDiagnosis(Diagnosis diagnosis)
    {
        modelDoctor.editDiagnosis(diagnosis);
    }

    @Override
    public synchronized ArrayList<Treatment> getAllTreatmentsOfPatient(Patient patient, Doctor doctor)
    {
        return modelDoctor.getAllTreatmentsOfPatient(patient, doctor);
    }

}
