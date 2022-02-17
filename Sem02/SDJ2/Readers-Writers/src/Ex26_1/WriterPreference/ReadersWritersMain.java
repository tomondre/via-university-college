package Ex26_1.WriterPreference;

public class ReadersWritersMain
{
  public static void main(String[] args)
  {
    ReadWrite readWrite = new ReaderPreference();

    Reader reader = new Reader(readWrite, 1);
    Writer writer = new Writer(readWrite, 1);

    new Thread(reader).start();
    new Thread(writer).start();
  }
}
