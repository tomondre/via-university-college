package Ex21_2;

import java.util.List;

public class Compressor
{
  private CompressionMethod compressionMethod;

  public Compressor()
  {
    compressionMethod = new ZipCompression();
  }

  public void setCompressionMethod(CompressionMethod method)
  {
    this.compressionMethod = method;
  }

  public void compress(List<String> files)
  {
    for (String file : files)
    {
      System.out.println(compressionMethod.compress(file));
    }
  }
}
