package net.qiguang.leetcode.L007_ReverseInteger;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Note:
 * The input is assumed to be a 32-bit signed integer.
 * Your function should return 0 when the reversed integer overflows.
 */
public class Solution {
    public static int reverse(int x) {
        int r = 0;
        for (int d = x % 10; x != 0; x /= 10) {
            d = x % 10;
            r = r * 10 + d;
            if (r % 10 != d) return 0;
        }
        return r;
    }
    public static void main(String[] args) {
        int[] nums = {123, -123, 1000, 1000000003, 1000000009, -2147483648};
        for (int i : nums) {
            System.out.format("%12d %12d\n", i, reverse(i));
        }
    }
}
