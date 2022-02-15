package client.view_models.manager;

import client.model.manager.EmployeeModelManager;
import client.model.shared.CallBackModel;
import client.model.shared.GetEmployeeDataModel;
import client.shared.SelectionModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.CurrentUser;
import shared.Doctor;
import shared.Employee;
import shared.Nurse;
import shared.callback.UpdateType;

import java.beans.PropertyChangeEvent;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class EmployeeViewModel
{
    private ObservableList<String> employeeType;
    private ObservableList<Employee> employees;
    private EmployeeModelManager employeeModelManager;
    private GetEmployeeDataModel getEmployeeDataModel;
    private StringProperty selectedEmployeeType;

    public EmployeeViewModel(Object employeeModelManager, Object getEmployeeDataModel, Object callBackModel)
    {
        CallBackModel callBack = (CallBackModel) callBackModel;
        callBack.addPropertyChangeListener(UpdateType.DOCTOR.toString(), this::employeeUpdated);
        callBack.addPropertyChangeListener(UpdateType.NURSE.toString(), this::employeeUpdated);
        this.getEmployeeDataModel = (GetEmployeeDataModel) getEmployeeDataModel;
        this.employeeModelManager = (EmployeeModelManager) employeeModelManager;
        employeeType = FXCollections.observableArrayList("Doctor", "Nurse");
        employees = FXCollections.observableArrayList();
        selectedEmployeeType = new SimpleStringProperty();
    }

    private void employeeUpdated(PropertyChangeEvent propertyChangeEvent)
    {
        if (CurrentUser.getInstance().isManager() && !employees.isEmpty())
        {
            if (isDoctor())
            {
                setEmployees(getEmployeeDataModel.getListOfAllDoctors());
            }
            else
              {
                setEmployees(getEmployeeDataModel.getListOfAllNurses());
            }
        }
    }

    public ObservableList<Employee> employeesProperty()
    {
        return employees;
    }

    private <T extends Employee> void setEmployees(ArrayList<T> employees)
    {
        this.employees.clear();
        this.employees.addAll(employees);
    }

    public void getEmployees()
    {
        if (isDoctor())
        {
            setEmployees(getEmployeeDataModel.getListOfAllDoctors());
        }
        else
        {
            setEmployees(getEmployeeDataModel.getListOfAllNurses());
        }
    }

    public void removeEmployee() throws InvalidParameterException
    {
        if (SelectionModel.getInstance().isEmpty())
        {
            throw new InvalidParameterException("Please select employee to remove.");
        }
        Employee employee = (Employee) SelectionModel.getInstance().get();
        if (employee instanceof Doctor)
        {
            employeeModelManager.removeDoctor((Doctor) employee);
        }
        else
        {
            employeeModelManager.removeNurse((Nurse) employee);
        }
    }

    public void editEmployee() throws InvalidParameterException
    {
        if(SelectionModel.getInstance().isEmpty())
        {
            throw new InvalidParameterException("Please select employee to edit.");
        }
    }

    public void addEmployee()
    {
        if (isDoctor())
        {
            SelectionModel.getInstance().set(new Doctor());
        }
        else
        {
            SelectionModel.getInstance().set(new Nurse());
        }
    }

    public ObservableList<String> getEmployeeType()
    {
        return employeeType;
    }

    public StringProperty selectedEmployeeTypeProperty()
    {
        return selectedEmployeeType;
    }

    private boolean isDoctor()
    {
        return selectedEmployeeType.getValue().equals("Doctor");
    }
}
