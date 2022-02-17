package client.view_models.manager;

import client.model.manager.EmployeeModelManager;
import client.model.manager.WardModelManager;
import client.model.shared.GetEmployeeDataModel;
import client.shared.SelectionModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.*;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.time.LocalDate;

public class AddEditEmployeeViewModel
{
    private StringProperty employeeSnn;
    private StringProperty employeeFirstName;
    private StringProperty employeeMiddleName;
    private StringProperty employeeLastName;
    private ObjectProperty<LocalDate> employeeDob;
    private StringProperty employeeStreet;
    private StringProperty employeeStreetNo;
    private StringProperty employeeCity;
    private StringProperty employeeZipCode;
    private StringProperty contactFirstName;
    private StringProperty contactLastName;
    private StringProperty contactPhoneNo;
    private ObjectProperty<Ward> selectedEmployeeWard;
    private ObservableList<Ward> wards;
    private StringProperty username;
    private StringProperty password;
    private StringProperty experience;
    private StringProperty education;
    private StringProperty[] textFields;
    private boolean toAdd;
    private boolean isDoctor;

    private EmployeeModelManager employeeModelManager;
    private GetEmployeeDataModel getEmployeeDataModel;
    private WardModelManager getWardsData;

    public AddEditEmployeeViewModel(Object employeeModelManager, Object getEmployeeDataModel, Object getWardsData)
    {
        this.employeeModelManager = (EmployeeModelManager) employeeModelManager;
        this.getEmployeeDataModel = (GetEmployeeDataModel) getEmployeeDataModel;
        this.getWardsData = (WardModelManager) getWardsData;
        employeeSnn = new SimpleStringProperty();
        employeeFirstName = new SimpleStringProperty();
        employeeMiddleName = new SimpleStringProperty();
        employeeLastName = new SimpleStringProperty();
        employeeDob = new SimpleObjectProperty<>();
        employeeStreet = new SimpleStringProperty();
        employeeStreetNo = new SimpleStringProperty();
        employeeCity = new SimpleStringProperty();
        employeeZipCode = new SimpleStringProperty();
        contactFirstName = new SimpleStringProperty();
        contactLastName = new SimpleStringProperty();
        contactPhoneNo = new SimpleStringProperty();
        wards = FXCollections.observableArrayList();
        selectedEmployeeWard = new SimpleObjectProperty<>();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        experience = new SimpleStringProperty();
        education = new SimpleStringProperty();
        textFields = new StringProperty[] {employeeSnn, employeeFirstName, employeeLastName,
                                           employeeStreet, employeeStreetNo, employeeCity, employeeZipCode,
                                           contactFirstName, contactLastName, contactPhoneNo, username, password,
                                           experience, education};
    }

    public void setChangeType()
    {
        Employee employee = (Employee) SelectionModel.getInstance().get();
        if (employee instanceof Doctor)
        {
            isDoctor = true;
        }
        if (employee == null || employee.getSsn() == 0L)
        {
            toAdd = true;
        }
        else
        {
            fillCommon(employee);
        }
    }

    private <T extends Employee> void fillCommon(T employee)
    {
        employeeSnn.setValue(String.valueOf(employee.getSsn()));
        employeeFirstName.setValue(employee.getFirstName());
        employeeMiddleName.setValue(employee.getMiddleName());
        employeeLastName.setValue(employee.getLastName());
        employeeDob.setValue(employee.getDob().toLocalDate());
        employeeStreet.setValue(employee.getAddress().getStreet());
        employeeStreetNo.setValue(employee.getAddress().getNumber());
        employeeCity.setValue(employee.getAddress().getCity());
        employeeZipCode.setValue(employee.getAddress().getZipcode());
        education.setValue(employee.getEducation());
        contactFirstName.setValue(employee.getContactFirstName());
        contactLastName.setValue(employee.getContactLastName());
        contactPhoneNo.setValue(employee.getContactPhoneNumber());
        username.setValue(employee.getEmail());
        password.setValue(employee.getPassword());
        fillSpecific(employee);
    }

    private void fillSpecific(Employee employee)
    {
        if (employee instanceof Doctor)
        {
            Doctor doctor = (Doctor) employee;
            experience.setValue(doctor.getSpecialization());
            selectedEmployeeWard.setValue(doctor.getWard());
        }
        else
        {
            Nurse nurse = (Nurse) employee;
            experience.setValue(nurse.getExperience());
        }
    }

    public boolean validateInput()
    {
        for (StringProperty field : textFields)
        {
            if (field.get() == null || field.get().isBlank())
            {
                return false;
            }
        }
        if (employeeDob == null || employeeDob.get() == null || (isDoctor && selectedEmployeeWard == null))
        {
            return false;
        }
        return true;
    }

    public boolean validateLoginData()
    {
        return Validator.isValidEmail(username.get()) && Validator.isValidPassword(password.get()) && Validator.isDobValid(employeeDob.get());
    }
    public void saveChanges() throws InvalidParameterException
    {
        if(!validateInput())
        {
            throw new InvalidParameterException("Please fill in all fields");
        }
        else if (!isValidSSN())
        {
            throw new InvalidParameterException("Invalid SSN. Please insert number between 1000000000 and 9999999999");
        }
        else if (!validateLoginData())
        {
           throw new InvalidParameterException("Invalid format of email/password/DOB");
        }
        getDataObject();
        if (toAdd && isDoctor)
        {
            employeeModelManager.addDoctor(getDataObject());
        }
        else if (toAdd && !isDoctor)
        {
            employeeModelManager.addNurse(getDataObject());
        }
        else if (!toAdd && isDoctor)
        {
            employeeModelManager.editDoctor(getDataObject());
        }
        else
        {
            employeeModelManager.editNurse(getDataObject());
        }
       clear();
    }

    private boolean isValidSSN()
    {
        return Validator.isValidSSN(Long.parseLong(employeeSnn.get()));
    }

    public void clear()
    {
        toAdd = false;
        isDoctor = false;
        employeeDob.set(null);
        selectedEmployeeWard.set(null);
        clearTextFields();
    }

    private void clearTextFields()
    {
        for (StringProperty filed : textFields)
        {
            filed.setValue("");
        }
    }

    public void getWards()
    {
        wards.addAll(getWardsData.getAllWards());
    }

    public <T extends Employee> T getDataObject()
    {
        Long ssn = Long.valueOf(employeeSnn.get());
        Date dob = Date.valueOf(employeeDob.get());
        Address address =
                new Address(employeeStreet.get(), employeeStreetNo.get(), employeeZipCode.get(), employeeCity.get());

        if (isDoctor)
        {
           return (T) new Doctor(employeeFirstName.get(), employeeMiddleName.get(), employeeLastName.get(), ssn, dob,
                                 address, contactFirstName.get(), null, contactLastName.get(), contactPhoneNo.get(), null,
                                 education.get(), experience.get(), selectedEmployeeWard.get(), username.get(), password.get());
        }
        else
        {
            return (T) new Nurse(ssn, 0L, employeeFirstName.get(), employeeMiddleName.get(), employeeLastName.get(), dob,
                                 address, contactFirstName.get(), null, contactLastName.get(), contactPhoneNo.get(), null,
                                 education.get(), experience.get(), username.get(), password.get());
        }
    }

    public StringProperty employeeSnnProperty()
    {
        return employeeSnn;
    }

    public StringProperty employeeFirstNameProperty()
    {
        return employeeFirstName;
    }

    public StringProperty employeeMiddleNameProperty()
    {
        return employeeMiddleName;
    }

    public StringProperty employeeLastNameProperty()
    {
        return employeeLastName;
    }

    public ObjectProperty<LocalDate> employeeDobProperty()
    {
        return employeeDob;
    }

    public StringProperty employeeStreetProperty()
    {
        return employeeStreet;
    }

    public StringProperty employeeStreetNoProperty()
    {
        return employeeStreetNo;
    }

    public StringProperty employeeCityProperty()
    {
        return employeeCity;
    }

    public StringProperty employeeZipCodeProperty()
    {
        return employeeZipCode;
    }

    public StringProperty contactFirstNameProperty()
    {
        return contactFirstName;
    }

    public StringProperty contactLastNameProperty()
    {
        return contactLastName;
    }

    public StringProperty contactPhoneNoProperty()
    {
        return contactPhoneNo;
    }

    public ObjectProperty<Ward> selectedEmployeeWardProperty()
    {
        return selectedEmployeeWard;
    }

    public StringProperty usernameProperty()
    {
        return username;
    }

    public StringProperty passwordProperty()
    {
        return password;
    }

    public StringProperty experienceProperty()
    {
        return experience;
    }

    public StringProperty educationProperty()
    {
        return education;
    }

    public ObservableList<Ward> wardsProperty()
    {
        return wards;
    }
}
