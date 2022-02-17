package client.core;

import client.view.sharted.View;
import client.view_models.doctor.*;
import client.view_models.login.DoctorMainViewModel;
import client.view_models.login.LoginViewModel;
import client.view_models.login.ManagerMainViewModel;
import client.view_models.login.NurseMainViewModel;
import client.view_models.manager.AddEditEmployeeViewModel;
import client.view_models.manager.AddEditWardViewModel;
import client.view_models.manager.EmployeeViewModel;
import client.view_models.manager.WardViewModel;
import client.view_models.nurse.AddPatientViewModel;
import client.view_models.nurse.AllAppointmentsViewModel;
import client.view_models.nurse.MakeAppointmentViewModel;
import client.view_models.nurse.AllPatientsViewModel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ViewModelFactory
{
    private Map<View, Object> viewModels;
    private static ViewModelFactory viewModelFactory;
    private static final Lock lock = new ReentrantLock();
    private ModelFactory modelFactory;

    private ViewModelFactory()
    {
        this.modelFactory = ModelFactory.getModelFactory();
        viewModels = new HashMap<>();
        createLoginViewModels();
        createManagerViewModels();
        createDoctorViewModels();
        createNurseViewModels();
    }

    public static ViewModelFactory getViewModelFactory()
    {
        if (viewModelFactory == null)
        {
            synchronized (lock)
            {
                if (viewModelFactory == null)
                {
                    viewModelFactory = new ViewModelFactory();
                }
            }
        }
        return viewModelFactory;
    }

    public Object getViewModel(View view)
    {
        return viewModels.get(view);
    }

    // TODO: 22/05/2021 Add the required models to the view models
    private void createLoginViewModels()
    {
        viewModels.put(View.LOGIN, new LoginViewModel(modelFactory.getModel(InterfaceEnum.LOGIN)));
        viewModels.put(View.DOCTOR_MAIN, new DoctorMainViewModel());
        viewModels.put(View.MANAGER_MAIN, new ManagerMainViewModel());
        viewModels.put(View.NURSE_MAIN, new NurseMainViewModel());
    }

    private void createManagerViewModels()
    {
        viewModels.put(View.EMPLOYEE, new EmployeeViewModel(modelFactory.getModel(InterfaceEnum.MANAGER_EMPLOYEE),
                                                            modelFactory.getModel(InterfaceEnum.SHARED_EMPLOYEE),
                                                            modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.WARD, new WardViewModel(modelFactory.getModel(InterfaceEnum.MANAGER_WARD),
                                                    modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.ADD_EDIT_EMPLOYEE,
                       new AddEditEmployeeViewModel(modelFactory.getModel(InterfaceEnum.MANAGER_EMPLOYEE),
                                                    modelFactory.getModel(InterfaceEnum.SHARED_EMPLOYEE),
                                                    modelFactory.getModel(InterfaceEnum.MANAGER_WARD)));
        viewModels.put(View.ADD_EDIT_WARD, new AddEditWardViewModel(modelFactory.getModel(InterfaceEnum.MANAGER_WARD)));
    }

    private void createDoctorViewModels()
    {
        viewModels.put(View.ADD_DIAGNOSE,
                       new AddDiagnoseViewModel(modelFactory.getModel(InterfaceEnum.DOCTOR_TREAT_UPDATE)));
        viewModels.put(View.ADD_EDIT_SAMPLE,
                       new AddEditSampleViewModel(modelFactory.getModel(InterfaceEnum.DOCTOR_SAMPLE)));
        viewModels.put(View.APPOINTMENTS,
                       new AppointmentsViewModel(modelFactory.getModel(InterfaceEnum.SHARED_APPOINTMENT),
                                                 modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.ASSIGN_NURSE, new AssignNurseViewModel(modelFactory.getModel(InterfaceEnum.DOCTOR_NURSE),
                                                                   modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.PATIENT_INFO,
                       new EditMedicalDescriptionViewModel(modelFactory.getModel(InterfaceEnum.SHARED_PATIENT)));
        viewModels.put(View.PATIENTS_SAMPLE,
                       new PatientsSampleViewModel(modelFactory.getModel(InterfaceEnum.DOCTOR_SAMPLE),
                                                   modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.PATIENTS, new PatientsViewModel(modelFactory.getModel(InterfaceEnum.SHARED_PATIENT),
                                                               modelFactory.getModel(InterfaceEnum.DOCTOR_TREAT_UPDATE),
                                                               modelFactory.getModel(InterfaceEnum.DOCTOR_SAMPLE),
                                                               modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.TREAT_PATIENT,
                       new TreatPatientViewModel(modelFactory.getModel(InterfaceEnum.DOCTOR_TREAT_UPDATE),
                                                 modelFactory.getModel(InterfaceEnum.CALLBACK)));
    }

    private void createNurseViewModels()
    {
        viewModels.put(View.ADD_PATIENT, new AddPatientViewModel(modelFactory.getModel(InterfaceEnum.NURSE_PATIENT)));
        viewModels.put(View.ALL_APPOINTMENTS,
                       new AllAppointmentsViewModel(modelFactory.getModel(InterfaceEnum.SHARED_APPOINTMENT),
                                                    modelFactory.getModel(InterfaceEnum.NURSE_APPOINTMENT),
                                                    modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.MAKE_APPOINTMENT,
                       new MakeAppointmentViewModel(modelFactory.getModel(InterfaceEnum.NURSE_APPOINTMENT),
                                                    modelFactory.getModel(InterfaceEnum.SHARED_EMPLOYEE),
                                                    modelFactory.getModel(InterfaceEnum.SHARED_PATIENT),
                                                    modelFactory.getModel(InterfaceEnum.CALLBACK)));
        viewModels.put(View.All_PATIENTS, new AllPatientsViewModel(modelFactory.getModel(InterfaceEnum.SHARED_PATIENT),
                                                                   modelFactory.getModel(InterfaceEnum.NURSE_PATIENT),
                                                                   modelFactory.getModel(InterfaceEnum.CALLBACK)));
    }
}
