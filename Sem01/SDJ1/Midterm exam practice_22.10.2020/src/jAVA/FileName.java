package jAVA;

public class FileName
{
  private String name, extension;

  public FileName(String name, String extension)
  {
    this.name = name;
    this.extension = extension;
  }

  public void set(String name, String extension)
  {
    this.name = name;
    this.extension = extension;
  }

  public String getName()
  {
    return name;
  }

  public String getExtension()
  {
    return extension;
  }

  public String getFullName()
  {
    return name + "." + extension;
  }
  public FileName copy()
  {
    return new FileName(name,extension);
  }


}
