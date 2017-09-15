package net.qiguang.leetcode;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * Hint:
 * Could you do it in-place with O(1) extra space?
 */
public class L189_RotateArray {
    // In-place with O(1) extra space
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        int h = gcd(k, nums.length);
        int offset = 0;
        while (offset < h) {
            int count = nums.length / h;
            int i = nums.length - 1 - offset;
            while (--count > 0) {
                int j = (i - k < 0) ? nums.length + (i - k) : i - k;
                int buf = nums[i];
                nums[i] = nums[j];
                nums[j] = buf;
                i = j;
            }
            offset++;
        }
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // In-place with O(1) extra space
    public static void rotateReverse(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }
    // Reverser array elements in [left, right]
    public static void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int buf = nums[left];
            nums[left] = nums[right];
            nums[right] = buf;
            left++;
            right--;
        }
    }

    // O(N) extra space, depends on k
    public static void rotateSub(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        int[] sub = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            sub[i - (nums.length - k)] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = sub[i];
        }
    }

    // O(N) extra space
    public static void rotateCopy(int[] nums, int k) {
        k %= nums.length;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            copy[i] = nums[i];
        for (int i = 0; i < nums.length; i++)
            nums[i] = copy[((nums.length - k) + i) % nums.length];
    }

    public static void main(String[] args) {
        for (int k = 0; k < 12; k++) {
            int[] a = new int[10];
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }
            rotateReverse(a, k);
            System.out.printf("%2d %s\n", k, Arrays.toString(a));
        }
    }
}
