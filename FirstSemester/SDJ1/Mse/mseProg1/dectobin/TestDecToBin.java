package dectobin;

public class TestDecToBin
{
  public static void main(String[] args)
  {
    runTest(17, "10001", "test1");
    runTest(19, "10011", "test2");
    runTest(147, "10010011", "test3");
    runTest(347, "101011011", "test4");
    runTest(122, "1111010", "test5");
    runTest(127, "1111111", "test6");
    runTest(-7, "", "test7");

  }



  private static void runTest(int input, String correctAnswer, String testName)
  {
    String output = null;
    try
    {
      output = DecToBin.decToBinary(input);
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
    if (!output.equals(correctAnswer))
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

