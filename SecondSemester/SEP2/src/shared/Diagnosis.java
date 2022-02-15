package shared;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Diagnosis implements Serializable
{
  private String name;
  private int severityLevel;
  private String description;
  private int id;
  private Date dateFrom;
  private Date dateTo = null;

  public Diagnosis(String name, int severityLevel, String description, Date dateFrom, int id)
  {
    this.name = name;
    this.severityLevel = severityLevel;
    this.description = description;
    this.dateFrom = dateFrom;
    this.id = id;
  }

  public Diagnosis(String name, int severityLevel, String description, Date dateFrom)
  {
    this.name = name;
    this.severityLevel = severityLevel;
    this.description = description;
    this.dateFrom = dateFrom;
  }

  public Diagnosis(String name, int severityLevel, String description, int id)
  {
    this.name = name;
    this.severityLevel = severityLevel;
    this.description = description;
    this.id = id;
  }


  public Date getDateTo()
  {
    return dateTo;
  }

  public void setDateTo(Date dateTo)
  {
    this.dateTo = dateTo;
  }

  public Date getDateFrom()
  {
    return dateFrom;
  }

  public void setDateFrom(Date dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public int getSeverityLevel()
  {
    return severityLevel;
  }

  public String getDescription()
  {
    return description;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setSeverityLevel(int severityLevel)
  {
    this.severityLevel = severityLevel;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Override public String toString()
  {
    return "Disease{" + "name='" + name + '\'' + ", severityLevel="
        + severityLevel + ", description='" + description + '\'' + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Diagnosis diagnosis = (Diagnosis) o;
    return severityLevel == diagnosis.severityLevel
        && Objects.equals(name, diagnosis.name) && Objects
        .equals(description, diagnosis.description);
  }
}
