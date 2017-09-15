package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class L169_MajorityElement {
    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) count++;
            else count--;
            if (count == 0) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }

    public static int majorityElementBits(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums)
            for (int i = 0; i < 32; i++)
                if ((num & (1 << i)) != 0) bits[i]++;
        int num = 0;
        for (int i = 0; i < 32; i++)
            if (bits[i] > nums.length / 2) num |= 1 << i;
        return num;
    }

    public static int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int n = 1; n < 10; n++) {
            int[] a = new int[1000];
            int m = r.nextInt();
            for (int i = 0; i < a.length; i++) {
                if (r.nextInt(3) > 0) a[i] = m;
                else a[i] = i;
            }
            System.out.printf("%12d %12d\n", m, majorityElement(a));
        }
        int[][] numss = {{1},
                {1, 0, 1},
                {0, 1, 1},
                {1, 1, 0}};
        for (int[] nums : numss)
            System.out.println(majorityElementBits(nums));

    }
}
