package Ex21_2;

public class SevenCCompression implements CompressionMethod
{
  private String fileType = ".7cc";

  @Override public String compress(String fileName)
  {
    return fileName + fileType;
  }
}
