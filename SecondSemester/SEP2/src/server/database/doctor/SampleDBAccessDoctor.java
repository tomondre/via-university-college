package server.database.doctor;

import shared.Patient;
import shared.Sample;

import java.util.ArrayList;

public interface SampleDBAccessDoctor
{
  ArrayList<Sample> getAllSamples();
  void createSample(Sample sample);
  void editSample(Sample sample);
  Sample getSampleById(int id);
  ArrayList<Sample> getAllPatientSamples(Patient patient);
}
