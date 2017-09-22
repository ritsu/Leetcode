package net.qiguang.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class L035_SearchInsertPosition {
    // 5 ms ~61%
    public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }
    public static int searchInsert(int[] nums, int target, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo >= hi) return target > nums[mid] ? mid + 1 : mid;    // Return where it should be inserted
        if      (target > nums[mid]) return searchInsert(nums, target, mid + 1, hi);
        else if (target < nums[mid]) return searchInsert(nums, target, lo, mid - 1);
        else                         return mid;                   // Return where it was found
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
    }
}
