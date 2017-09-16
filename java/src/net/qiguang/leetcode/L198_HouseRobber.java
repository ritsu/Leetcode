package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of
 * money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the
 * maximum amount of money you can rob tonight without alerting the police.
 */
public class L198_HouseRobber {
    /**
     * Given int[] a[0..n]
     *
     * Index   Max
     * -----------------------------------------------------
     *     1:  a[0]
     *     2:  max(a[0], a[1])
     *     3:  max(a[0] + a[3], a[2])
     *     4:  max(max(2) + a[4], max(3))
     *     5:  max(max(3) + a[5], max(4))
     *     n:  max(max(n-2) + a[n], max(n-1))
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int maxA = nums[0];
        int oldA = 0;
        int maxB = nums[1];
        int oldB = 0;
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                oldA = maxA;
                maxA = Math.max(maxA, oldB) + nums[i];
            } else {
                oldB = maxB;
                maxB = Math.max(maxB, oldA) + nums[i];
            }
        }
        return Math.max(maxA, maxB);
    }

    public static int robBrute(int[] nums) {
        if (nums.length <= 4) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);
            if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
            int ac = nums[0] + nums[2];
            int bd = nums[1] + nums[3];
            int ad = nums[0] + nums[3];
            return Math.max(Math.max(ac, bd), ad);
        }
        int ac = nums[0] + robBrute(nums, 2);
        int bd = nums[1] + robBrute(nums, 3);
        return Math.max(ac, bd);
    }
    public static int robBrute(int[] nums, int start) {
        int r = nums.length - start;
        if (r <= 4) {
            if (r == 0) return 0;
            if (r == 1) return nums[nums.length - 1];
            if (r == 2) return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
            if (r == 3) return Math.max(nums[nums.length - 3] + nums[nums.length - 1], nums[nums.length - 2]);
            int ac = nums[nums.length - 4] + nums[nums.length - 2];
            int bd = nums[nums.length - 3] + nums[nums.length - 1];
            int ad = nums[nums.length - 4] + nums[nums.length - 1];
            return Math.max(Math.max(ac, bd), ad);
        }
        int ac = nums[start]     + robBrute(nums, start + 2);
        int bd = nums[start + 1] + robBrute(nums, start + 3);
        return Math.max(ac, bd);
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int[] a = new int[r.nextInt(10)];
            for (int j = 0; j < a.length; j++) {
                a[j] = r.nextInt(10) * 10;
            }
            int sum = 0;
            for (int n : a) {
                sum += n;
            }
            System.out.printf("%4d %4d : %s\n", rob(a), robBrute(a), Arrays.toString(a));
        }

        System.out.println();
        int[][] numss = {{1, 0, 1, 10, 1},
                {0, 1, 10, 1},
                {1, 0, 1, 10, 1, 1, 10, 1},
                {1, 0, 1, 10, 1, 10, 1, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 0, 1}};
        for (int[] nums : numss) {
            System.out.printf("%4d %4d : %4s\n", rob(nums), robBrute(nums), Arrays.toString(nums));
        }
    }
}
