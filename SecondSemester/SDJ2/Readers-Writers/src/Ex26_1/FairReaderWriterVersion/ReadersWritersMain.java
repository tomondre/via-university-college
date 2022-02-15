package Ex26_1.FairReaderWriterVersion;

public class ReadersWritersMain
{
  public static void main(String[] args)
  {
    ReadWrite readWrite = new ReadWriteFair();

    Thread[] threads = new Thread[10];
    int numberOfWriters = 5;
    for (int i = 0; i < numberOfWriters; i++)
    {
      threads[i] = new Thread(new Reader(readWrite, i));
    }

    for (int i = numberOfWriters; i < threads.length; i++)
    {
      threads[i] = new Thread( new Writer(readWrite, i));
    }

    for (Thread thread : threads)
    {
      thread.start();
    }
  }
}
