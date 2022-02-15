import java.util.HashSet;

public class SubSetTest {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
    }

    private static void test1() {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        boolean isAsubSet = false;

        set1.add("John");
        set1.add("Jim");
        set2.add("John");
        set2.add("James");

        runTest(set1, set2, isAsubSet, "test1");
    }

    private static void test2() {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        boolean isAsubSet = true;

        set1.add("John");
        set1.add("Jim");
        set2.add("Susanna");
        set2.add("James");
        set2.add("John");
        set2.add("Jim");


        runTest(set1, set2, isAsubSet, "test2");
    }

    private static void test3() {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        boolean isAsubSet = true;

        set1.add("John");
        set1.add("Jim");
        set1.add("Susanna");
        set1.add("James");

        set2.add("John");
        set2.add("Jim");
        set2.add("Susanna");
        set2.add("James");

        runTest(set1, set2, isAsubSet, "test3");
    }

    private static void runTest(HashSet<String> set1, HashSet<String> set2, boolean isAsubSet, String testName) {
        SubSet s = new SubSet();
        HashSet<String> set1Temp = new HashSet<>();
        HashSet<String> set2Temp = new HashSet<>();
        set1Temp.addAll(set1);
        set2Temp.addAll(set2);

        boolean result;
        try {
            result = s.isASubSet(set1, set2);
        } catch (Exception e) {
            outputFail(testName, "Failed with exception: " + e);
            return;
        }

        if(!set1.equals(set1Temp)){
            outputFail(testName,
                    "set1 has changed from: " + set1Temp.toString() + " to: " + set1.toString());
        }
        else if(!set2.equals(set2Temp)){
            outputFail(testName,
                    "set2 has changed from: " + set2Temp.toString() + " to: " + set2.toString());
        }
        else if (result!=isAsubSet)
            outputFail(testName,
                    "Expected output " + isAsubSet + " but got " + result);
        else {
            outputPass(testName);
            System.out.println("Output " + isAsubSet + " and got " + result);
        }
    }

    private static void outputPass(String testName) {
        System.out.println("[Pass " + testName + "]");
    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }

}
