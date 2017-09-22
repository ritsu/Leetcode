package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
 * transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class L122_BestTimeToBuyAndSellStockII {
    // 1 ms ~54%
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            profit += Math.max(0, prices[i] - prices[i-1]);
        return profit;
    }

    public static void main(String[] args) {
        int[][] pricess = {{0,1,2,3,4,5,6},
                {0,0,0,0,0,0,0},
                {6,5,4,3,2,1,0},
                {0},
                {},
                {0,1},
                {1,0},
                {0,0}};
        for (int[] prices : pricess) {
            System.out.println(Arrays.toString(prices));
            System.out.println(maxProfit(prices));
        }
        // Random prices
        for (int i = 0; i < 10; i++) {
            int[] a = new int[20];
            Random r = new Random();
            for (int j = 0; j < a.length; j++) {
                a[j] = r.nextInt(100);
            }
            System.out.println(Arrays.toString(a));
            System.out.println(maxProfit(a));
        }
    }
}
