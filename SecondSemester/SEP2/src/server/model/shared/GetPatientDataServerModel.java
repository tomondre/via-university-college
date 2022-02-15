package server.model.shared;

import shared.Patient;
import shared.Sample;

import java.util.ArrayList;

public interface GetPatientDataServerModel
{
    ArrayList<Patient> getAllPatients();
    Patient getPatientBySSN(long ssn);
  ArrayList<Sample> getPatientSample(long ssn);
}
