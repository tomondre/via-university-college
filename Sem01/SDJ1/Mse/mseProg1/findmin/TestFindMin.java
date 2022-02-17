package findmin;

public class TestFindMin
{
  public static void main(String[] args)
  {
    test1();
    test2();
    test3();
  }


  private static void test1()
  {
    int[] input = { 96, 66};
    int correctAnswer = 66;
    runTest(input, correctAnswer, "test1");
  }

  private static void test2()
  {
    int[] input = { 17, 46 };
    int correctAnswer = 17;
    runTest(input, correctAnswer, "test2");
  }

  private static void test3()
  {
    int[] input = { 90, 8};
    int correctAnswer = 8;

    runTest(input, correctAnswer, "test3");
  }

  private static void runTest(int[] input, int correctAnswer, String testName)
  {
    FindMin fm = new FindMin();
    int output = 0;
    try
    {
      output = fm.findMin(input[0], input[1]);
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
