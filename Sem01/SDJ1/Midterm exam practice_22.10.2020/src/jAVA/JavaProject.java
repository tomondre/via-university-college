package jAVA;

import java.util.ArrayList;

public class JavaProject
{
  private String name;
  private ArrayList<JavaFile> list;

  public JavaProject(String name)
  {
    this.name = name;
    list = new ArrayList<JavaFile>();
  }

  public void addJavaFile(JavaFile file)
  {
    list.add(file);
  }

  public FileName getFileName(int index)
  {
    return list.get(index).getFileName();
  }

  public JavaFile getFirstJavaFileWithAMainMethod()
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).hasAMainMethod())
      {
        return list.get(i);
      }
    }
    return null;
  }

  public String getProjectName()
  {
    return name;
  }

}
