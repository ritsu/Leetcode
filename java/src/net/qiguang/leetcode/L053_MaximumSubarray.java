package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class L053_MaximumSubarray {
    // Solution
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }

    // Divide and conquer solution
    public static int maxSubArrayDivide(int[] nums) {
        int[] m = maxSubArrayDivide(nums, 0, nums.length - 1);
        return Math.max(Math.max(m[0], m[1]), Math.max(m[2], m[3]));
    }
    public static int[] maxSubArrayDivide(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return new int[] {nums[lo], nums[lo], nums[lo], nums[lo]};
        }
        int mid = lo + (hi - lo) / 2;
        int[] mlo = maxSubArrayDivide(nums, lo, mid);
        int[] mhi = maxSubArrayDivide(nums, mid + 1, hi);

        int maxleft = (mlo[3] + mhi[0] > mlo[0]) ? mlo[3] + mhi[0] : mlo[0];
        int maxright = (mhi[3] + mlo[2] > mhi[2]) ? mhi[3] + mlo[2] : mhi[2];
        int maxmid = (mlo[2] > 0 && mhi[0] > 0) ? mlo[2] + mhi[0] : Math.max(mlo[2], mhi[0]);
        maxmid = Math.max(maxmid, Math.max(mlo[1], mhi[1]));
        int sumall = mlo[3] + mhi[3];

        return new int[] {maxleft, maxmid, maxright, sumall};
    }

    // For visualization only
    public static int[] maxSubArrayArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int left = 0;
        int right = 0;
        int sent = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
                right = i;
                left = sent;
            }
            if (sum < 0) {
                sum = 0;
                sent = i + 1;
            }
        }
        return Arrays.copyOfRange(nums, left, right + 1);
    }

    public static void main(String[] args) {
        // Specific test cases
        int[][] numss = {
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
                {-1, -2},
                {-1, -2, 0},
                {-1},
                {1, 2}
        };
        for (int[] nums : numss) {
            System.out.format("%12s: %s\n", "Array", Arrays.toString(nums));
            System.out.format("%12s: %s\n", "SubArray", Arrays.toString(maxSubArrayArray(nums)));
            System.out.format("%12s: %s\n", "Solution1", maxSubArray(nums));
            System.out.format("%12s: %s\n", "Solution2", maxSubArrayDivide(nums));
        }

        // Random test cases
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int[] nums = new int[20];
            for (int j = 0; j < 20; j++) {
                nums[j] = r.nextInt(100) - 50;
            }
            System.out.format("%12s: %s\n", "Array", Arrays.toString(nums));
            System.out.format("%12s: %s\n", "SubArray", Arrays.toString(maxSubArrayArray(nums)));
            System.out.format("%12s: %s\n", "Solution1", maxSubArray(nums));
            System.out.format("%12s: %s\n", "Solution2", maxSubArrayDivide(nums));
        }
    }
}
