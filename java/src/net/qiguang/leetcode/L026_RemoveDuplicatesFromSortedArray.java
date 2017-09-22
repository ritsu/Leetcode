package net.qiguang.leetcode;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class L026_RemoveDuplicatesFromSortedArray {
    // 13 ms ~64%
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[end]) {
                nums[++end] = nums[i];
            }
        }
        return ++end;
    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 2, 3, 4, 5}
                    ,{0, 0, 2, 3, 4, 5}
                    ,{0, 1, 2, 3, 4, 4}
                    ,{0, 0, 0, 5, 5, 5}
                    ,{0, 0, 0, 0, 0, 0}
                    ,{0, 0}
                    ,{0}
                    ,{}};
        for (int[] n : a) {
            System.out.format("original: %s\nremoveDuplicates(): %d\nnew: %s\n\n",
                    Arrays.toString(n),
                    removeDuplicates(n),
                    Arrays.toString(n));
        }
    }
}
