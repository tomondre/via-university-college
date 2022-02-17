package client.model.shared;

import shared.Patient;
import shared.Sample;

import java.util.ArrayList;

public interface GetPatientDataModel
{
    ArrayList<Patient> getAllPatients();
    Patient getPatientBySSN(long ssn);
    ArrayList<Sample> getPatientSamples(long ssn);
}
