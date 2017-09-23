package net.qiguang.leetcode;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class L219_ContainsDuplicateII {
    // 18 ms ~66%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                if (i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        L219_ContainsDuplicateII lc = new L219_ContainsDuplicateII();
        int[][] numss = {{},
                {0},
                {0, 1},
                {0, 0},
                {0, 1, 2, 3, 4, 5, 0}};
        for (int[] nums : numss) {
            System.out.printf("%8s %8s\n",
                    lc.containsNearbyDuplicate(nums, 1),
                    lc.containsNearbyDuplicate(nums, 6)
            );
        }
    }
}
