public abstract class Education
{

  private String code, title;

  public Education(String code, String title)
  {
    this.code = code;
    this.title = title;
  }

  public String getCode()
  {
    return code;
  }

  public String getTitle()
  {
    return title;
  }

  public String toString()
  {
    return "Code: " + code + ", title: " + title;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Education))
    {
      return false;
    }
    Education other = (Education) obj;

    return code.equals(other.code) && title.equals(other.title);
  }

}
