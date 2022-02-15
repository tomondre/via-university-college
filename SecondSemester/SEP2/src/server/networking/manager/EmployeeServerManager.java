package server.networking.manager;

import shared.Doctor;
import shared.Nurse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EmployeeServerManager extends Remote
{
    String addDoctor(Doctor doctor) throws RemoteException;
    String addNurse(Nurse nurse) throws RemoteException;
    String editDoctor(Doctor doctor) throws RemoteException;
    String editNurse(Nurse nurse) throws RemoteException;
    String removeDoctor(Doctor doctor) throws RemoteException;
    String removeNurse(Nurse nurse) throws RemoteException;
}
