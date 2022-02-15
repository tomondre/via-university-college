package findclosest;

public class TestFindClosest
{
  public static void main(String[] args)
  {
    test1();
    test2();
    test3();
  }


  private static void test1()
  {
    int[] input = { 196, 266, 382, 463, 578, 637, 7100, 899, 998, 117, 2213, 227, 2228, 374, 73, 77, 41, 25, 53, 93 };
    int correctAnswer = 4;
    runTest(input, correctAnswer, "test1");
  }

  private static void test2()
  {
    int[] input = { 90, 8, 38, 69, 82, 79, 67, 27, 17, 46, 78, 444, 47, 18, 36, 55, 59, 74, 12, 95 };
    int correctAnswer = 1;
    runTest(input, correctAnswer, "test2");
  }

  private static void test3()
  {
    int[] input = { 190, -6, -38, 269, 832, 7399, 637, 237, 217, 416, 978, 1444, 4177, 197, 1118, 367, 55, -55, 74, 12, 95 };
    int correctAnswer = 7;

    runTest(input, correctAnswer, "test3");
  }

  private static void runTest(int[] input, int correctAnswer, String testName)
  {
    FindClosest fc = new FindClosest();
        int output = 0;
    try
    {
      output = fc.findClosest(input);
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