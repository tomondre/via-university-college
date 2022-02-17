package shared;

import java.io.Serializable;

public class Treatment implements Serializable
{
  private String medication;
  private String description;
  private String diagnosisName;
  private int severityLevel;

  public Treatment(String medication, String description)
  {
    this.medication = medication;
    this.description = description;
  }

  public String getMedication()
  {
    return medication;
  }

  public String getDescription()
  {
    return description;
  }

  public void setMedication(String medication)
  {
    this.medication = medication;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getDiagnosisName()
  {
    return diagnosisName;
  }

  public int getSeverityLevel()
  {
    return severityLevel;
  }

  public void setDiagnosisName(String diagnosisName)
  {
    this.diagnosisName = diagnosisName;
  }

  public void setSeverityLevel(int severityLevel)
  {
    this.severityLevel = severityLevel;
  }

  @Override public String toString()
  {
    return "Treatment{" + "medication='" + medication + '\'' + ", description='"
        + description + '\'' + '}';
  }
}
