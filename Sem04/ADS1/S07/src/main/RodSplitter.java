import java.util.HashMap;

public class RodSplitter {
    public HashMap<Integer, Integer> costs;

    public RodSplitter() {
        costs = new HashMap<>();
        costs.put(1, 1);
        costs.put(2, 5);
        costs.put(3, 8);
        costs.put(4, 9);
        costs.put(5, 10);
        costs.put(6, 17);
        costs.put(7, 17);
        costs.put(8, 20);
        costs.put(9, 24);
        costs.put(10, 30);
    }

    public int splitBrutForce(int size) {
        int max = costs.get(size);

        for (int i = 1; i < size; i++) {
            max = Math.max(max, splitBrutForce(size - i) + costs.get(i));
        }

        return max;

//        int max = 0;
//
//        for (int i = 1; i < size; i++) {
//            int temp = costs.get(i) + costs.get(size - i);
//            if (temp > max) {
//                max = temp;
//            }
//        }
//        return max;

//        if (size == 0) {
//            return 0;
//        }
//
//        return costs.get(size) + splitBrutForce(size - 1);
    }

    public int split(int size) {
        if (costs.containsKey(size)) {
            return costs.get(size);
        }

        return Integer.max(split(size - 1), split(size - 2));
    }

    public static void main(String[] args) {
        RodSplitter rodSplitter = new RodSplitter();
        int split = rodSplitter.splitBrutForce(4);
        System.out.println(split);
    }
}
