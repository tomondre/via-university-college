package leetcode.Ex1_Two_Sum;

public class Main {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int num1 = nums[j];
                if (num + num1 == target && i != j){
                    int[] ints = new int[2];
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return new int[2];
    }
}
