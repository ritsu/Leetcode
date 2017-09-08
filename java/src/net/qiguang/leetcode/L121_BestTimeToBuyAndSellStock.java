package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 *
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class L121_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            if      (price < min)          min = price;
            else if (price - min > profit) profit = price - min;
        }
        return profit;
    }
    public static int[] maxProfitIndices(int[] prices) {
        int min = 0;
        int buy = 0;
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            }
            else if (prices[i] - prices[min] > prices[sell] - prices[buy]) {
                buy = min;
                sell = i;
            }
        }
        return new int[] {buy, sell};
    }
    public static void main(String[] args) {
        int[][] pricess = {{0,1,2,3,4,5,6},
                {0,0,0,0,0,0,0},
                {6,5,4,3,2,1,0},
                {0},
                {0,1},
                {1,0},
                {0,0}};
        for (int[] prices : pricess) {
            System.out.println(Arrays.toString(prices));
            int[] pi = maxProfitIndices(prices);
            int p = maxProfit(prices);
            System.out.printf("[%d]%d : [%d]%d = %d\n", pi[0], prices[pi[0]], pi[1], prices[pi[1]], p);
        }

        // Random prices
        for (int i = 0; i < 10; i++) {
            int[] a = new int[20];
            Random r = new Random();
            for (int j = 0; j < a.length; j++) {
                a[j] = r.nextInt(100);
            }
            System.out.println(Arrays.toString(a));
            int[] pi = maxProfitIndices(a);
            int p = maxProfit(a);
            System.out.printf("[%d]%d : [%d]%d = %d\n", pi[0], a[pi[0]], pi[1], a[pi[1]], p);
        }
    }
}
