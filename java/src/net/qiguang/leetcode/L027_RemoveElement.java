package net.qiguang.leetcode;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 *
 * Your function should return length = 2, with the first two elements of nums being 2
 *
 */
public class L027_RemoveElement {
    // 9 ms ~53%
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int end = nums.length;
        for (int i = 0; i < end; i++) {
            if (nums[i] == val) {
                nums[i] = nums[--end];
                i--;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[][] a = {{3, 2, 2, 3}
                    ,{3, 3}
                    ,{3, 2}
                    ,{2, 3}
                    ,{2, 2}
                    ,{3}
                    ,{2}
                    ,{}};
        int n = 3;
        for (int[] nums : a) {
            System.out.format("%s, %d\n", Arrays.toString(nums), n);
            System.out.format("%d, %s\n\n", removeElement(nums, n), Arrays.toString(nums));
        }


    }
}
