package S02_lists_queues_stacks.Ex06;

public class Main {
    public static void main(String[] args) {
        long fine = getFine(5);
        System.out.println(fine);

        int day = whatDay(66500);
        System.out.println(day);
    }

    public static long getFine(int day) {
        long fine = 2;

        for (int i = 1; i < day; i++) {
            fine *= fine;
        }

        return fine;
    }

    public static int whatDay(long dollars) {
        long fine = 2;

        for (int i = 1; i < 100; i++) {
            if (dollars < fine) {
                return i;
            }

            fine *= fine;
        }
        return -1;
    }

}
