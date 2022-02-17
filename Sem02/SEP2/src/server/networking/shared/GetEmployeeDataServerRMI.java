package server.networking.shared;

import server.model.shared.GetEmployeeDataServerModel;
import server.model.shared.GetEmployeeDataServerModelImpl;
import shared.Doctor;
import shared.Nurse;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GetEmployeeDataServerRMI implements GetEmployeeDataServer
{
    private GetEmployeeDataServerModel sharedServerModel;

    public GetEmployeeDataServerRMI(Registry registry) throws AlreadyBoundException, RemoteException
    {
        sharedServerModel = new GetEmployeeDataServerModelImpl();
        UnicastRemoteObject.exportObject(this, 0);
        startServer(registry);
    }

    private void startServer(Registry registry) throws AlreadyBoundException, RemoteException
    {
        registry.bind("GetEmployeeDataServer", this);
        System.out.println("GetEmployeeDataServer is running.");
    }

    @Override
    public synchronized ArrayList<Doctor> getListOfAllDoctors()
    {
        return sharedServerModel.getListOfAllDoctors();
    }

    @Override
    public synchronized ArrayList<Nurse> getListOfAllNurses()
    {
        return sharedServerModel.getListOfAllNurses();
    }

    @Override
    public synchronized Doctor getDoctorBySSN(long ssn)
    {
        return sharedServerModel.getDoctorBySSN(ssn);
    }

    @Override
    public synchronized Nurse getNurseBySSN(long ssn)
    {
        return sharedServerModel.getNurseBySSN(ssn);
    }
}
