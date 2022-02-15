package server.networking.doctor;

import server.model.doctor.NursesServerModelDoctor;
import server.model.doctor.NursesServerModelDoctorImpl;
import shared.Doctor;
import shared.Nurse;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class NursesServerDoctorRMI implements NursesServerDoctor
{
    private NursesServerModelDoctor modelDoctor;

    public NursesServerDoctorRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        modelDoctor = new NursesServerModelDoctorImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("NursesServerDoctor", this);
        System.out.println("NursesServerDoctor is running!");
    }

    @Override
    public synchronized ArrayList<Nurse> getAllAvailableNurses()
    {
        return modelDoctor.getAllAvailableNurses();
    }

    @Override
    public synchronized void assignNurse(Nurse nurse, Doctor doctor)
    {
        modelDoctor.assignNurse(nurse, doctor);
    }

    @Override
    public synchronized ArrayList<Nurse> getAllNursesAssignedToMe(Doctor doctor)
    {
        return modelDoctor.getAllNursesAssignedToMe(doctor);
    }
}
