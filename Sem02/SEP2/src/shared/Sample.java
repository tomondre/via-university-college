package shared;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Sample implements Serializable
{
  private String type;
  private String result;
  private int priority;
  private Date deadline;
  private long patient_ssn;
  private int sample_id;

  public Sample(String type, String result, int priority, Date deadline,
      long patient_ssn, int sample_id)
  {
    this.type = type;
    this.result = result;
    this.priority = priority;
    this.deadline = deadline;
    this.patient_ssn = patient_ssn;
    this.sample_id = sample_id;
  }

  public int getSample_id()
  {
    return sample_id;
  }

  public void setSample_id(int sample_id)
  {
    this.sample_id = sample_id;
  }

  public long getPatient_ssn()
  {
    return patient_ssn;
  }

  public void setPatient_ssn(long patient_ssn)
  {
    this.patient_ssn = patient_ssn;
  }

  public Date getDeadline()
  {
    return deadline;
  }

  public void setDeadline(Date deadline)
  {
    this.deadline = deadline;
  }

  public String getType()
  {
    return type;
  }

  public String getResult()
  {
    return result;
  }

  public int getPriority()
  {
    return priority;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void setResult(String result)
  {
    this.result = result;
  }

  public void setPriority(int priority)
  {
    this.priority = priority;
  }

  @Override public String toString()
  {
    return "Sample{" + "type='" + type + '\'' + ", result='" + result + '\''
        + ", priority=" + priority + ", deadline=" + deadline + ", patient_ssn="
        + patient_ssn + ", sample_id=" + sample_id + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Sample sample = (Sample) o;
    return priority == sample.priority && patient_ssn == sample.patient_ssn
        && Objects.equals(type, sample.type) && Objects
        .equals(result, sample.result);
  }
}
