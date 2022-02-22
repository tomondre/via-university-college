import java.io.*;
import java.util.ArrayList;

public class MyFileIO
{
  public void writeToFile(String fileName, Object obj)
      throws FileNotFoundException, IOException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    ObjectOutputStream write = new ObjectOutputStream(fileOut);
    write.writeObject(obj);
  }

  public void writeToFile(String fileName, Object[] obj)
      throws FileNotFoundException, IOException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    ObjectOutputStream write = new ObjectOutputStream(fileOut);
    for (Object o : obj)
    {
      write.writeObject(o);
    }
  }

  public Object readObjectFromFile(String fileName)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream read = new ObjectInputStream(fileIn);
    Object temp = read.readObject();
    read.close();
    return temp;
  }

  public Object[] readArrayFromFile(String fileName)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream read = new ObjectInputStream(fileIn);
    ArrayList temp = new ArrayList<>();
    while (true)
    {
      try
      {
        temp.add(read.readObject());
      }
      catch (EOFException e)
      {
        break;
      }
    }
    return temp.toArray(new Object[temp.size()]);
  }
}