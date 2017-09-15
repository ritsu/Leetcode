package net.qiguang.leetcode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 */
public class L172_FactorialTrailingZeroes {
    public static long trailingZeroes(int n) {
        int zeroes = 0;
        while (n/5 > 0) {
            zeroes += n/5;
            n /= 5;
        }
        return zeroes;
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++)
            System.out.printf("%4d %4d\n", i, trailingZeroes(i));
    }
}
