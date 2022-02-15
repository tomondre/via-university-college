package server.model.doctor;

import shared.Patient;
import shared.Sample;

import java.util.ArrayList;

public interface SampleServerModelDoctor
{
    ArrayList<Sample> getAllSamples();
    void createSample(Sample sample);
    void editSample(Sample sample);
    Sample getSampleById(int id);
  ArrayList<Sample> getAllPatientSamples(Patient patient);
}
