package leetcode.Ex121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = 100000;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < min)
            {
                min = price;
                max = price;
            } else {
                if (price > max)
                {
                    max = price;
                }
            }
        }
        return max - min;
    }
}