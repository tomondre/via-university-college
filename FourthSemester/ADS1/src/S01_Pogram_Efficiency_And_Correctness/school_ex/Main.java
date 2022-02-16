package S01_Pogram_Efficiency_And_Correctness.school_ex;

public class Main {
    public static void main(String[] args) {
        int[] ints = {8, 1, 2, 2, 6, 7, 9,};
        int[] sort = sort(ints);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] arr) {
        boolean isChanged;
        do {
            isChanged = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isChanged = true;
                }
            }
        } while (isChanged);
        return arr;
    }
}
