package client.core;

import client.networking.doctor.*;
import client.networking.login.LoginClientImpl;
import client.networking.manager.EmployeeClientRMI;
import client.networking.manager.WardClientRMI;
import client.networking.nurse.AppointmentsClientNurseRMI;
import client.networking.nurse.PatientClientNurseRMI;
import client.networking.shared.CallBackClientRMI;
import client.networking.shared.GetAppointmentDataClientRMI;
import client.networking.shared.GetEmployeeDataClientRMI;
import client.networking.shared.GetPatientDataClientRMI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientFactory
{
    private Map<InterfaceEnum, Object> clients;
    private static ClientFactory clientFactory;
    private static final Lock lock = new ReentrantLock();

    private ClientFactory()
    {
        clients = new HashMap<>();
        createLoginClients();
        createManagerClients();
        createDoctorClients();
        createNurseClients();
        createSharedClients();
    }

    public static ClientFactory getClientFactory()
    {
        if (clientFactory == null)
        {
            synchronized (lock)
            {
                if (clientFactory == null)
                {
                    clientFactory = new ClientFactory();
                }
            }
        }
        return clientFactory;
    }
    private void createLoginClients()
    {
        clients.put(InterfaceEnum.LOGIN, new LoginClientImpl());
    }

    private void createManagerClients()
    {
        clients.put(InterfaceEnum.MANAGER_EMPLOYEE, new EmployeeClientRMI());
        clients.put(InterfaceEnum.MANAGER_WARD, new WardClientRMI());
    }

    private void createDoctorClients()
    {
        clients.put(InterfaceEnum.DOCTOR_NURSE, new NurseClientDoctorRMI());
        clients.put(InterfaceEnum.DOCTOR_SAMPLE, new SampleClientDoctorRMI());
        clients.put(InterfaceEnum.DOCTOR_TREAT_UPDATE, new TreatAndUpdateClientDoctorRMI());
    }

    private void createNurseClients()
    {
        clients.put(InterfaceEnum.NURSE_APPOINTMENT, new AppointmentsClientNurseRMI());
        clients.put(InterfaceEnum.NURSE_PATIENT, new PatientClientNurseRMI());
    }

    private void createSharedClients()
    {
        clients.put(InterfaceEnum.SHARED_APPOINTMENT, new GetAppointmentDataClientRMI());
        clients.put(InterfaceEnum.SHARED_EMPLOYEE, new GetEmployeeDataClientRMI());
        clients.put(InterfaceEnum.SHARED_PATIENT, new GetPatientDataClientRMI());
        clients.put(InterfaceEnum.CALLBACK, new CallBackClientRMI());
    }
    public Object getClient(InterfaceEnum client)
    {
        return clients.get(client);
    }
}
