package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *     Given nums = [2, 7, 11, 15], target = 9,
 *
 *     Because nums[0] + nums[1] = 2 + 7 = 9,
 *     return [0, 1].
 */
public class L001_TwoSum {
    // 7 ms ~92%
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[] {i, m.get(target - nums[i])};
            }
            m.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 7, 11, 15}, {3, 2, 4}};
        int[] target = {9, 6};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(twoSum(nums[i], target[i])));
        }

    }
}
