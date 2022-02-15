package client.model.doctor;

import shared.Patient;
import shared.Sample;

import java.util.ArrayList;

public interface SampleModelDoctor
{
  ArrayList<Sample> getAllSamples();
  void createSample(Sample sample);
  void editSample(Sample sample);
  Sample getSampleByID(int id);
  ArrayList<Sample> getAllPatientSamples(Patient patient);
}
