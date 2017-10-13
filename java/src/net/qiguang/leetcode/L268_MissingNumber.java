package net.qiguang.leetcode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */
public class L268_MissingNumber {
    // 1 ms ~35%
    public int missingNumber(int[] nums) {
        int max = (nums.length * (nums.length + 1)) / 2;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return max - sum;
    }
    public static void main(String[] args) {
        L268_MissingNumber lc = new L268_MissingNumber();
        System.out.println(lc.missingNumber(new int[] {0}));
        System.out.println(lc.missingNumber(new int[] {1}));
        System.out.println(lc.missingNumber(new int[] {0, 1}));
        System.out.println(lc.missingNumber(new int[] {0, 2}));
        System.out.println(lc.missingNumber(new int[] {1, 2}));
    }
}
