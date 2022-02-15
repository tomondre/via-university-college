package shared;

import java.io.Serializable;
import java.sql.Date;

public class Doctor extends Employee implements Serializable
{
    private String specialization;
    private Ward ward;

    public Doctor()
    {
        super(null, null, null, 0L, null, null, null,
              null, null, null, null, null, null, null);
    }

    public Doctor(String firstName, String middleName, String lastName, long ssn, Date dob, Address address,
                  String contactFirstName, String contactMiddleName, String contactLastName, String contactPhoneNumber,
                  Date startDate, String education, String specialization, Ward ward, String email, String password)

    {
        super(firstName, middleName, lastName, ssn, dob, address, contactFirstName, contactMiddleName, contactLastName,
              contactPhoneNumber, startDate, education, email, password);
        this.specialization = specialization;
        this.ward = ward;
    }

    public Ward getWard()
    {
        return ward;
    }

    public void setWard(Ward ward)
    {
        this.ward = ward;
    }

    public String getSpecialization()
    {
        return specialization;
    }

    public void setSpecialization(String specialization)
    {
        this.specialization = specialization;
    }

    @Override
    public String toString()
    {
        return super.toString() + "specialization='" + specialization + '\'';
    }
}
