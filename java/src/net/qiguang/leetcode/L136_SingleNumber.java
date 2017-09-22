package net.qiguang.leetcode;

import java.util.HashMap;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class L136_SingleNumber {
    // 1 ms ~32%
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int n : nums)
            a = a ^ n;
        return a;
    }

    public static void main(String[] args) {
        L136_SingleNumber lc = new L136_SingleNumber();
        int[][] numss = {{0},
                {0, 1, 0},
                {0, 1, 0, 2, 2}};
        for (int[] nums : numss) {
            System.out.println(lc.singleNumber(nums));
        }
    }
}
