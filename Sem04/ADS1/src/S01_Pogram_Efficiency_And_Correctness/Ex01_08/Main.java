package S01_Pogram_Efficiency_And_Correctness.Ex01_08;

public class Main {

    public static void main(String[] args) {
        int[] arr = {6, 11, 3, 8, 9, 9, 1, 4, 7};
        int i = somOfRange(arr, 2, 5);
        System.out.println(i);
    }

    public static int somOfRange(int[] arr, int index1, int index2) {
        int sum = 0;
        for (int i = index1; i <= index2; i++) {
            sum += arr[i];
        }

        return sum;
    }
}

