import java.util.HashSet;

public class GCDtest {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
    }

    private static void test1() {
        int p=13;
        int a=5;

        int gcd = 1;

        runTest(a,p, gcd, "test1");
    }

    private static void test2() {
        int p=30;
        int a=10;

        int gcd = 10;

        runTest(a,p, gcd, "test2");
    }

    private static void test3() {
        int p=28;
        int a=16;

        int gcd = 4;

        runTest(a,p, gcd, "test3");
    }

    private static void runTest(int p, int a, int gcdResult, String testName) {
        GCD gcdSolver = new GCD();
        int gcd;

        try {
            gcd = gcdSolver.findGCD(p, a);
        } catch (Exception e) {
            outputFail(testName, "Failed with exception: " + e);
            return;
        }

        if(gcd !=gcdResult){
            outputFail(testName,
                    "Got: " + gcd + " but expected: " + gcdResult);
        }
        else {
            outputPass(testName,"GCD("+a+", "+p+ ")  = " + gcd);
        }
    }

    private static void outputPass(String testName, String message) {
        System.out.println("[Pass " + testName + "]"+ message);

    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }
}
