package Ex01_06;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        int fibonacci = fibonacci(10);
        long timeInMillis1 = Calendar.getInstance().getTimeInMillis();

        System.out.println(fibonacci);
        System.out.println("Time: " + (timeInMillis1 - timeInMillis));


        long timeInMillis2 = Calendar.getInstance().getTimeInMillis();
        int i = fibonacciRecursive(10);
        long timeInMillis3 = Calendar.getInstance().getTimeInMillis();

        System.out.println(i);
        System.out.println("Time: " + (timeInMillis3 - timeInMillis2));
    }

    // 1, 1, 2, 3, 5, 8, 13
    public static int fibonacci(int num) {
        int last = 1;
        int preLast = 1;
        for (int i = 2; i < num; i++) {
            int temp = last;
            last = preLast + last;
            preLast = temp;
        }

        return last;
    }

    public static int fibonacciRecursive(int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
    }
}
