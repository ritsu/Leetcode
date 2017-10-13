package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class L349_IntersectionOfTwoArrays {
    // 5 ms ~74%
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);
        int[] intersect = new int[set.size()];
        int idx = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                set.remove(num);
                intersect[idx++] = num;
            }
        }
        return Arrays.copyOf(intersect, idx);
    }
    // 5 ms ~74%
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            if (set.contains(nums2[i])) intersect.add(nums2[i]);
        int[] ret = new int[intersect.size()];
        int i = 0;
        for (int n : intersect)
            ret[i++] = n;
        return ret;
    }
    public static void main(String[] args) {
        L349_IntersectionOfTwoArrays lc = new L349_IntersectionOfTwoArrays();
        int[] a = new int[] {1, 2, 2, 1};
        int[] b = new int[] {2, 2};
        System.out.println(Arrays.toString(lc.intersection(a, b)));
    }
}
