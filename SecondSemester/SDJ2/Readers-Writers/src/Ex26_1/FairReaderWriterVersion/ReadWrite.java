package Ex26_1.FairReaderWriterVersion;

public interface ReadWrite
{
  void acquireRead();
  void releaseRead();
  void acquireWrite();
  void releaseWrite();
}
