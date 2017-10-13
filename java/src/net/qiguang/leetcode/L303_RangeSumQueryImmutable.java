package net.qiguang.leetcode;

import java.util.Random;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class L303_RangeSumQueryImmutable {
    // 209 ms ~79%
    static class NumArray {
        int[] a;
        int[] nums;

        public NumArray(int[] nums) {
            a = new int[nums.length];
            int sum = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                sum += nums[i];
                a[i] = sum;
            }
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if (j == a.length - 1)
                return a[i];
            return a[i] - a[j + 1];
        }
        public int sumRangeSlow(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++)
                sum += nums[k];
            return sum;
        }
    }
    public static void main(String[] args) {
        int n = 100;
        int[] nums = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
            nums[i] = r.nextInt(2*n) - n;
        NumArray obj = new NumArray(nums);
        for (int i = 0; i < n; i++) {
            int j = r.nextInt(50);
            int k = 50 + r.nextInt(50);
            if (obj.sumRangeSlow(j,k) != obj.sumRange(j,k))
                System.out.printf("fail");
            if (obj.sumRangeSlow(j,n-1) != obj.sumRange(j,n-1))
                System.out.printf("fail");
            if (obj.sumRangeSlow(0,j) != obj.sumRange(0,j))
                System.out.printf("fail");
        }
    }
}
