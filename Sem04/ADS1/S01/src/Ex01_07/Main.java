package Ex01_07;

public class Main {
    public static void main(String[] args) {
        System.out.println("isPrime() = " + isPrime(48));
    }

    /*
    Pseudo code:
    for 2 ... n
        if m divisible by i without remainder return false
    return true
     Time Complexity: O(n)
     */
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
