package client.networking.shared;

import shared.Doctor;
import shared.Nurse;
import shared.util.PropertyChangeSubject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GetEmployeeDataClient extends Remote, PropertyChangeSubject
{
    ArrayList<Doctor> getListOfAllDoctors() throws RemoteException;
    ArrayList<Nurse> getListOfAllNurses() throws RemoteException;
    Doctor getDoctorBySSN(long ssn) throws RemoteException;
    Nurse getNurseBySSN(long ssn) throws RemoteException;
}
