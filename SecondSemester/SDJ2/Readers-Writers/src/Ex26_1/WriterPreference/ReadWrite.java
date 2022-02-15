package Ex26_1.WriterPreference;

public interface ReadWrite
{
  void acquireRead();
  void releaseRead();
  void acquireWrite();
  void releaseWrite();
}
