import java.util.HashSet;

public class RelativeComplementTest {

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

        HashSet<String> resultSet = new HashSet<>();

        set1.add("John");
        set1.add("Jim");
        set2.add("John");
        set2.add("James");

        resultSet.add("Jim");

        runTest(set1, set2, resultSet, "test1");
    }

    private static void test2() {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        HashSet<String> resultSet = new HashSet<>();

        set1.add("John");
        set1.add("Jim");
        set2.add("Susanna");
        set2.add("James");

        resultSet.add("John");
        resultSet.add("Jim");

        runTest(set1, set2, resultSet, "test2");
    }

    private static void test3() {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        HashSet<String> resultSet = new HashSet<>();

        set1.add("John");
        set1.add("Jim");
        set1.add("Susanna");
        set1.add("James");
        set2.add("John");
        set2.add("Jim");
        set2.add("Susanna");
        set2.add("James");

        runTest(set1, set2, resultSet, "test3");
    }

    private static void runTest(HashSet<String> set1, HashSet<String> set2, HashSet<String> resultSet, String testName) {
        RelativeComplement rc = new RelativeComplement();

        HashSet<String> set;
        try {
            set = rc.relativeComplement(set1, set2);
        } catch (Exception e) {
            outputFail(testName, "Failed with exception: " + e);
            return;
        }
        if (!set.equals(resultSet))
            outputFail(testName,
                    "Expected output " + resultSet.toString() + " but got " + set.toString());
        else {
            outputPass(testName);
            System.out.println("Output " + resultSet.toString() + " input 1 " + set1.toString() + " input 2 " + set2.toString());
        }
    }

    private static void outputPass(String testName) {
        System.out.println("[Pass " + testName + "]");
    }

    private static void outputFail(String testName, String message) {
        System.out.println("[FAIL " + testName + "] " + message);
    }

}
