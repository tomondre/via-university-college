package leetcode.Ex13_Roman_to_Integer;

public class Main {
    public static void main(String[] args) {

    }

    public static int romanToInt(String s) {
        char previous = s.charAt(s.length() - 1);
        int sum = 0;
        for (int i = s.length() - 1; 0 <= i; i--) {
            char current = s.charAt(i);
            switch (current) {
                case 'I':
                    if (previous == 'V' || previous == 'X') {
                        sum--;
                    } else {
                        sum++;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;

                case 'X':
                    if (previous == 'L' || previous == 'C') {
                        sum -= 10;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (previous == 'D' || previous == 'M') {
                        sum -= 100;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;

                case 'M':
                    sum += 1000;
                    break;
            }
            previous = current;
        }
        return sum;
    }

}
