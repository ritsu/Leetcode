package net.qiguang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class L217_ContainsDuplicate {
    // 19 ms ~55%
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        L217_ContainsDuplicate lc = new L217_ContainsDuplicate();
        int[][] numss = {{},
                {0},
                {0, 1},
                {0, 0},
                {0, 1, 2, 3, 4, 5, 0}};
        for (int[] nums : numss) {
            System.out.println(lc.containsDuplicate(nums));
        }
    }
}
