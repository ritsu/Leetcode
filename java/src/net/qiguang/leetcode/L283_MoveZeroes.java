package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class L283_MoveZeroes {
    // 3 ms ~22%
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0)
                nums[left++] = nums[right];
            right++;
        }
        while (left < nums.length)
            nums[left++] = 0;
    }
    // 3 ms ~22%
    public void moveZeroes2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                if (left == right) {
                    left++;
                    right++;
                }
                else {
                    nums[left++] = nums[right];
                    nums[right++] = 0;
                }
            }
            else {
                right++;
            }
        }
    }
    public static void main(String[] args) {
        L283_MoveZeroes lc = new L283_MoveZeroes();
        int n = 20;
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            if (r.nextBoolean())
                a[i] = 0;
            else
                a[i] = r.nextInt(n);
        }
        System.out.println(Arrays.toString(a));
        lc.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
