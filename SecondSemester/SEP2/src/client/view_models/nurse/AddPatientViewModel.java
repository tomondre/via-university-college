package client.view_models.nurse;

import client.model.nurse.PatientModelNurse;
import client.shared.SelectionModel;
import javafx.beans.property.*;
import shared.Address;
import shared.Patient;
import shared.Validator;

import java.security.InvalidParameterException;
import java.sql.Date;
import java.time.LocalDate;

public class AddPatientViewModel
{
    private StringProperty firstNamePatient;
    private StringProperty middleNamePatient;
    private StringProperty lastNamePatient;
    private ObjectProperty<LocalDate> dobPatient;
    private Property<String> genderPatient;
    private StringProperty bloodTypePatient;
    private StringProperty ssnPatient;
    private StringProperty streetPatient;
    private StringProperty streetNoPatient;
    private StringProperty cityPatient;
    private StringProperty zipCodePatient;
    private StringProperty contactFirstName;
    private StringProperty contactLastName;
    private StringProperty contactPhoneNo;
    private StringProperty medicalDescriptionPatient;
    private StringProperty[] fields;

    private PatientModelNurse patientModelNurse;

    public AddPatientViewModel(Object patientModelNurse)
    {
        this.patientModelNurse = (PatientModelNurse) patientModelNurse;
        firstNamePatient = new SimpleStringProperty();
        middleNamePatient = new SimpleStringProperty();
        lastNamePatient = new SimpleStringProperty();
        dobPatient = new SimpleObjectProperty<>();
        genderPatient = new SimpleStringProperty();
        bloodTypePatient = new SimpleStringProperty();
        ssnPatient = new SimpleStringProperty();
        streetPatient = new SimpleStringProperty();
        streetNoPatient = new SimpleStringProperty();
        cityPatient = new SimpleStringProperty();
        zipCodePatient = new SimpleStringProperty();
        contactFirstName = new SimpleStringProperty();
        contactLastName = new SimpleStringProperty();
        contactPhoneNo = new SimpleStringProperty();
        medicalDescriptionPatient = new SimpleStringProperty();
        fields = new StringProperty[] {firstNamePatient, lastNamePatient,
                                       bloodTypePatient, ssnPatient, streetPatient, streetNoPatient, cityPatient,
                                       zipCodePatient, contactFirstName, contactLastName, contactPhoneNo,
                                       medicalDescriptionPatient};
    }

    public void fillPatientData()
    {
        if (!SelectionModel.getInstance().isEmpty())
        {
            Patient patient = (Patient) SelectionModel.getInstance().get();
            firstNamePatient.set(patient.getFirstName());
            middleNamePatient.set(patient.getMiddleName());
            lastNamePatient.set(patient.getLastName());
            dobPatient.set(patient.getDob().toLocalDate());
            genderPatient.setValue(String.valueOf(patient.getGender()));
            bloodTypePatient.set(patient.getBlood_type());
            ssnPatient.set(String.valueOf(patient.getSsn()));
            streetPatient.set(patient.getAddress().getStreet());
            streetNoPatient.set(patient.getAddress().getNumber());
            cityPatient.set(patient.getAddress().getCity());
            zipCodePatient.set(patient.getAddress().getZipcode());
            contactFirstName.set(patient.getContactFirstName());
            contactLastName.set(patient.getContactLastName());
            contactPhoneNo.set(patient.getContactPhoneNumber());
            medicalDescriptionPatient.set(patient.getMedical_description());
        }
    }

    public void clear()
    {
        dobPatient.set(null);
        for (StringProperty field : fields)
        {
            field.set("");
        }
    }

    private boolean validateInput()
    {
        for (StringProperty field : fields)
        {
            if (field.get() == null || field.get().isBlank())
            {
                return false;
            }
        }
        return Validator.isDobValid(dobPatient.get());
    }

    public StringProperty firstNamePatientProperty()
    {
        return firstNamePatient;
    }

    public StringProperty middleNamePatientProperty()
    {
        return middleNamePatient;
    }

    public StringProperty lastNamePatientProperty()
    {
        return lastNamePatient;
    }

    public ObjectProperty<LocalDate> dobPatientProperty()
    {
        return dobPatient;
    }

    public Property<String> genderPatientProperty()
    {
        return genderPatient;
    }

    public StringProperty bloodTypePatientProperty()
    {
        return bloodTypePatient;
    }

    public StringProperty ssnPatientProperty()
    {
        return ssnPatient;
    }

    public StringProperty streetPatientProperty()
    {
        return streetPatient;
    }

    public StringProperty streetNoPatientProperty()
    {
        return streetNoPatient;
    }

    public StringProperty cityPatientProperty()
    {
        return cityPatient;
    }

    public StringProperty zipCodePatientProperty()
    {
        return zipCodePatient;
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

    public StringProperty medicalDescriptionPatientProperty()
    {
        return medicalDescriptionPatient;
    }

    public void savePatient() throws InvalidParameterException
    {
        if(!validateInput())
        {
            throw new InvalidParameterException("Please fill in all the fields to create a patient.");
        }
        else if (!isValidSSN())
        {
            throw new InvalidParameterException("Invalid SSN. Please insert number between 1000000000 and 9999999999");
        }
        Address address = new Address(streetPatient.getValue(), streetNoPatient.getValue(), zipCodePatient.getValue(),
                                      cityPatient.getValue());
        Patient patient =
                new Patient(firstNamePatient.getValue(), middleNamePatient.getValue(), lastNamePatient.getValue(),
                            Long.parseLong(ssnPatient.getValue()), Date.valueOf(dobPatient.getValue()), address,
                            contactFirstName.getValue(), null, contactLastName.getValue(), contactPhoneNo.getValue(),
                            bloodTypePatient.getValue(), medicalDescriptionPatient.getValue(),
                            genderPatient.getValue().charAt(0));
        patientModelNurse.addPatient(patient);
    }

    private boolean isValidSSN()
    {
        return Validator.isValidSSN(Long.parseLong(ssnPatient.get()));
    }
}
