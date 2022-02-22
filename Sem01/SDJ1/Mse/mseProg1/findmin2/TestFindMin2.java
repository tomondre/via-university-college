package findmin2;

public class TestFindMin2
{
  public static void main(String[] args)
  {
    test1();
    test2();
    test3();
  }


  private static void test1()
  {
    int[] input = { 96, 66, 82, 63, 78, 37, 100, 96, 98, 17, 13, 7, 28, 74, 73, 77, 41, 25, 53, 93 };
    int correctAnswer = 7;
    runTest(input, correctAnswer, "test1");
  }

  private static void test2()
  {
    int[] input = { 90, 8, 38, 69, 82, 79, 67, 27, 17, 46, 78, 14, 47, 18, 36, 55, 55, 74, 12, 95 };
    int correctAnswer = 8;
    runTest(input, correctAnswer, "test2");
  }

  private static void test3()
  {
    int[] input = { 90, -2, 38, 69, 82, 79, 67, 27, 17, 46, 78, 14, 47, 97, 18, 36, 55, 55, 74, 12, 95 };
    int correctAnswer = -2;

    runTest(input, correctAnswer, "test3");
  }

  private static void runTest(int[] input, int correctAnswer, String testName)
  {
    FindMin2 fm = new FindMin2();
    int output = 0;
    try
    {
      output = fm.findMin2(input);
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
