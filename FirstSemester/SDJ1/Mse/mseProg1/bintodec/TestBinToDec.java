package bintodec;

public class TestBinToDec
{
  public static void main(String[] args)
  {
    runTest(new int[]{1,0,0,0,1}, 17, "test1");
    runTest(new int[]{1,0,0,1,1}, 19, "test2");
    runTest(new int[]{1,0,0,1,0,0,1,1}, 147, "test3");
    runTest(new int[]{1,0,1,0,1,1,0,1,1}, 347, "test4");
    runTest(new int[]{1,1,1,1,0,1,0}, 122, "test5");
    runTest(new int[]{1,1,1,1,1,1,1}, 127, "test6");
    runTest(new int[]{}, 0, "test7");

  }



  private static void runTest(int[] input, int correctAnswer, String testName)
  {
    int output;
    try
    {
      output = BinToDec.binToDecimal(input);
    }
    catch (IllegalArgumentException e) {
      outputPass(testName);

      return;
    }
    catch (Exception e)
    {
      outputFail(testName, "Failed with exception: " + e);
      return;
    }
    if (output != correctAnswer)
      outputFail(testName,
          "Expected output " + correctAnswer + " but got " + output);
    else
      outputPass(testName);
  }


  private static void outputPass(String testName) {
    System.out.println("[Pass " + testName + "]");
  }

  private static void outputFail(String testName, String message) {
    System.out.println("[FAIL " + testName + "] " + message);
  }
}

