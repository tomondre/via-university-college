package leetcode.Ex9_Palindrome;

public class Main {
    public static void main(String[] args) {
        int num = 100301;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        String string = "" + x;
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
