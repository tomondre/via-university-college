package client.view_models.nurse;

import client.model.nurse.PatientModelNurse;
import client.model.shared.CallBackModel;
import client.model.shared.GetPatientDataModel;
import client.shared.SelectionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.CurrentUser;
import shared.Patient;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class AllPatientsViewModel
{
    private ObservableList<Patient> patients;
    private GetPatientDataModel getAllPatientsData;
    private PatientModelNurse patientNurseModel;

    public AllPatientsViewModel(Object getAllPatientsData, Object patientNurseModel, Object callBackModel)
    {
        this.getAllPatientsData = (GetPatientDataModel) getAllPatientsData;
        this.patientNurseModel = (PatientModelNurse) patientNurseModel;
        patients = FXCollections.observableArrayList();

       CallBackModel callBack = (CallBackModel) callBackModel;
       callBack.addPropertyChangeListener(UpdateType.PATIENT.toString(),
                                           this::patientUpdated);
    }

    private void patientUpdated(PropertyChangeEvent evt)
    {
        System.out.println("Here");
        if (CurrentUser.getInstance().isNurse())
        {
            loadPatientsData();
        }
    }

    public ObservableList<Patient> allPatientsProperty()
    {
        return patients;
    }

    public void loadPatientsData()
    {
        ArrayList<Patient> patients = getAllPatientsData.getAllPatients();
        this.patients.clear();
        this.patients.addAll(patients);
    }

    public void editPatient() throws InvalidParameterException
    {
        if (SelectionModel.getInstance().isEmpty())
        {
            throw new InvalidParameterException("Please select patient to edit.");
        }
    }

    public void removePatient(Patient patient)
    {
        if (patient == null)
        {
            throw new InvalidParameterException("Please select patient to remove.");
        }
        patientNurseModel.removePatient(patient);
    }
}
