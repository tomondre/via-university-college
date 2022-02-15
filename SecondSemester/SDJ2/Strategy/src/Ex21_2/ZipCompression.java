package Ex21_2;

public class ZipCompression implements CompressionMethod
{
  private String fileType = ".zip";

  @Override public String compress(String fileName)
  {
    return fileName + fileType;
  }
}
