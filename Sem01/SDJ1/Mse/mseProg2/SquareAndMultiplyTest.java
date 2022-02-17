public class SquareAndMultiplyTest {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
    }

    private static void test1() {
        int base = 3;
        int exponent = 5;
        int modulo = 8;
        int sum = 3;

        runTest(base, exponent, modulo, sum, "test1");
    }

    private static void test2() {

        int base = 113;
        int exponent = 47;
        int modulo = 77;
        int sum = 64;

        runTest(base, exponent, modulo, sum, "test2");
    }

    private static void test3() {
        int base = 17;
        int exponent = 59;
        int modulo = 45;
        int sum = 8;

        runTest(base, exponent, modulo, sum, "test3");
    }

    private static void test4() {
        int base = 72;
        int exponent = 43;
        int modulo = 61;
        int sum = 50;

        runTest(base, exponent, modulo, sum, "test4");
    }

    private static void test5() {
        int base = 72;
        int exponent = 143;
        int modulo = 114;
        int sum = 90;

        runTest(base, exponent, modulo, sum, "test5");
    }

    private static void runTest(int base, int exponent, int modulo, int resultSum, String testName) {
        SquareAndMultiply sam = new SquareAndMultiply();
        int sum;

        try {
            sum = sam.squareAndMultiply(base,exponent,modulo);
        } catch (Exception e) {
            outputFail(testName, "Failed with exception: " + e);
            return;
        }

        if (sum != resultSum) {
            outputFail(testName,
                    "Got: " + sum + " but expected: " + resultSum);
        } else {
            outputPass(testName, "Got: " + sum + " and expected: " + resultSum);
        }
    }

    private static void outputPass(String testName, String message) {
        System.out.println("[Pass " + testName + "] " + message);

    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }
}
