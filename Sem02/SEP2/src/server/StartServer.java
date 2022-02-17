package server;

import server.networking.doctor.*;
import server.networking.login.LoginServer;
import server.networking.login.LoginServerRMI;
import server.networking.manager.EmployeeServerManager;
import server.networking.manager.EmployeeServerManagerRMI;
import server.networking.manager.WardServerManager;
import server.networking.manager.WardServerManagerRMI;
import server.networking.nurse.*;
import server.networking.shared.*;
import server.networking.shared.ServerPool;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartServer
{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {
        Registry registry = LocateRegistry.createRegistry(1099);

        //Login server start
        LoginServer loginServer = new LoginServerRMI(registry);
        System.out.println();

        //Manager server start
        EmployeeServerManager employeeServerManager = new EmployeeServerManagerRMI(registry);
        WardServerManager serverManager = new WardServerManagerRMI(registry);
        System.out.println();

        //Doctor server start
        NursesServerDoctor nursesServerDoctor = new NursesServerDoctorRMI(registry);
        SampleServerDoctor sampleServerDoctor = new SampleServerDoctorRMI(registry);
        TreatAndUpdateServerDoctor treatAndUpdateServerDoctor = new TreatAndUpdateServerDoctorRMI(registry);
        System.out.println();

        //Nurse server start
        AppointmentsServerNurse appointmentsServerNurse = new AppointmentsServerNurseRMI(registry);
        PatientServerNurse patientServerNurse = new PatientServerNurseRMI(registry);

        //Shared server start
        ServerPool pool = new ServerPoolRMI(registry);
        GetAppointmentDataServer getAppointmentDataServer = new GetAppointmentDataServerRMI(registry);
        GetEmployeeDataServer getEmployeeDataServer = new GetEmployeeDataServerRMI(registry);
        GetPatientDataServer getPatientDataServer = new GetPatientDataServerRMI(registry);
    }

}
