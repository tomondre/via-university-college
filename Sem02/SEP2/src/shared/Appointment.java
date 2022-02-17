package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class Appointment implements Serializable
{
  private Timestamp from;
  private Timestamp to;
  private long doctorSSN;
  private long patientSSN;

  public Appointment(Timestamp from, Timestamp to, long doctorSSN,
      long patientSSN)
  {
    this.from = from;
    this.to = to;
    this.doctorSSN = doctorSSN;
    this.patientSSN = patientSSN;
  }

  public Timestamp getFrom()
  {
    return from;
  }

  public Timestamp getTo()
  {
    return to;
  }

  public long getDoctorSSN()
  {
    return doctorSSN;
  }

  public long getPatientSSN()
  {
    return patientSSN;
  }

  public void setFrom(Timestamp from)
  {
    this.from = from;
  }

  public void setTo(Timestamp to)
  {
    this.to = to;
  }

  public void setDoctorSSN(long doctorSSN)
  {
    this.doctorSSN = doctorSSN;
  }

  public void setPatientSSN(long patientSSN)
  {
    this.patientSSN = patientSSN;
  }

  public boolean equals(Object object)
  {
    if (!(object instanceof Appointment))
    {
      return false;
    }

    Appointment other = (Appointment) object;

    return other.getPatientSSN() == patientSSN
        && other.getDoctorSSN() == doctorSSN && other.from.equals(from);
  }

  @Override public String toString()
  {
    return "Appointment{" + "from=" + from + ", to=" + to + ", doctorSSN="
        + doctorSSN + ", patientSSN=" + patientSSN + '}';
  }
}
