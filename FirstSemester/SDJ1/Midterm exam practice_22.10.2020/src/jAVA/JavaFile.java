package jAVA;

public class JavaFile
{
  private boolean hasAMainMethod;
  private FileName filename;

  public JavaFile(String fileename)
  {
   String[] parts = fileename.split(".");
  filename = new FileName(parts[0],parts[1]);
  hasAMainMethod = false;
  }
  public FileName getFileName()
  {
    return filename.copy();
  }
  public boolean hasAMainMethod()
  {
    return hasAMainMethod;
  }
  public void addAMainMethod()
  {
    hasAMainMethod = true;
  }

  @Override public String toString()
  {
    return "JavaFile{" + "hasAMainMethod=" + hasAMainMethod + ", filename="
        + filename + '}';
  }
}
