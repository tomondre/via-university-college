package Ex21_2;

import java.util.ArrayList;

public class RunCompressor
{
  public static void main(String[] args)
  {
    Compressor compressor = new Compressor();

    ArrayList<String> list = new ArrayList<String>();
    list.add("FirstString");
    list.add("SecondString");
    list.add("ThirdString");
    list.add("FourthString");
    list.add("FifthString");
    list.add("SixthString");

    compressor.compress(list);

    System.out.println("---.7cc----");

    compressor.setCompressionMethod(new SevenCCompression());
    compressor.compress(list);
  }
}
