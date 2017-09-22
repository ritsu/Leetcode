package net.qiguang.leetcode;

import java.util.Arrays;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class L066_PlusOne {
    // 0 ms ~31%
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        int[] a = new int[digits.length + 1];
        a[0] = 1;
        return a;
    }

    public static void main(String[] args) {
        int[][] digitss = {
                {9, 9, 9, 9},
                {1, 9, 1, 9},
                {9, 1, 9, 1},
                {1, 9, 9, 9},
                {9},
                {0}
        };
        for (int[] digits : digitss) {
            System.out.format("%16s\n", Arrays.toString(digits));
            System.out.format("%16s\n", Arrays.toString(plusOne(digits)));
        }
    }
}
