package client.core;

import client.model.doctor.*;
import client.model.login.LoginImpl;
import client.model.manager.EmployeeModelManagerImpl;
import client.model.manager.WardModelManagerImpl;
import client.model.nurse.AppointmentsModelNurseImpl;
import client.model.nurse.PatientModelNurseImpl;
import client.model.shared.CallBackModelImpl;
import client.model.shared.GetAppointmentDataModelImpl;
import client.model.shared.GetEmployeeDataModelImpl;
import client.model.shared.GetPatientDataModelImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ModelFactory
{
    private Map<InterfaceEnum, Object> models;
    private static ModelFactory modelFactory;
    private static final Lock lock = new ReentrantLock();
    private ClientFactory clientFactory;

    private ModelFactory()
    {
        clientFactory = ClientFactory.getClientFactory();
        models = new HashMap<>();
        createLoginModels();
        createManagerModels();
        createDoctorModels();
        createNurseModels();
        createSharedModels();
    }

    public static ModelFactory getModelFactory()
    {
        if (modelFactory == null)
        {
            synchronized (lock)
            {
                if (modelFactory == null)
                {
                    modelFactory = new ModelFactory();
                }
            }
        }
        return modelFactory;
    }

    private void createLoginModels()
    {
        models.put(InterfaceEnum.LOGIN, new LoginImpl(clientFactory.getClient(InterfaceEnum.LOGIN)));
    }

    private void createManagerModels()
    {
        models.put(InterfaceEnum.MANAGER_EMPLOYEE, new EmployeeModelManagerImpl(clientFactory.getClient(InterfaceEnum.MANAGER_EMPLOYEE)));
        models.put(InterfaceEnum.MANAGER_WARD, new WardModelManagerImpl(clientFactory.getClient(InterfaceEnum.MANAGER_WARD)));
    }

    private void createDoctorModels()
    {
        models.put(InterfaceEnum.DOCTOR_NURSE, new NursesModelDoctorImpl(clientFactory.getClient(InterfaceEnum.DOCTOR_NURSE)));
        models.put(InterfaceEnum.DOCTOR_SAMPLE, new SampleModelDoctorImpl(clientFactory.getClient(InterfaceEnum.DOCTOR_SAMPLE)));
        models.put(InterfaceEnum.DOCTOR_TREAT_UPDATE, new TreatAndUpdateModelDoctorImpl(clientFactory.getClient(InterfaceEnum.DOCTOR_TREAT_UPDATE)));
    }

    private void createNurseModels()
    {
        models.put(InterfaceEnum.NURSE_APPOINTMENT, new AppointmentsModelNurseImpl(clientFactory.getClient(InterfaceEnum.NURSE_APPOINTMENT)));
        models.put(InterfaceEnum.NURSE_PATIENT, new PatientModelNurseImpl(clientFactory.getClient(InterfaceEnum.NURSE_PATIENT)));
    }

    private void createSharedModels()
    {
        models.put(InterfaceEnum.SHARED_APPOINTMENT, new GetAppointmentDataModelImpl(clientFactory.getClient(InterfaceEnum.SHARED_APPOINTMENT)));
        models.put(InterfaceEnum.SHARED_EMPLOYEE, new GetEmployeeDataModelImpl(clientFactory.getClient(InterfaceEnum.SHARED_EMPLOYEE)));
        models.put(InterfaceEnum.SHARED_PATIENT, new GetPatientDataModelImpl(clientFactory.getClient(InterfaceEnum.SHARED_PATIENT)));
        models.put(InterfaceEnum.CALLBACK, new CallBackModelImpl(clientFactory.getClient(InterfaceEnum.CALLBACK)));
    }

    public Object getModel(InterfaceEnum model)
    {
        return models.get(model);
    }
}
