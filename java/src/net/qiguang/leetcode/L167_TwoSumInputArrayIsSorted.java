package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
 * must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

public class L167_TwoSumInputArrayIsSorted {
    // 1 ms ~40%
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if      (numbers[left] + numbers[right] > target) right--;
            else if (numbers[left] + numbers[right] < target) left++;
            else return new int[] {left + 1, right + 1};
        }
        return null;
    }

    // 5 ms ~13%
    public static int[] twoSumHashMap(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (hm.containsKey(key))
                return new int[] {hm.get(key) + 1, i + 1};
            hm.put(numbers[i], i);
        }
        return null;
    }

    // 5 ms ~13%
    public static int[] twoSumBinarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            int lo = i + 1;
            int hi = numbers.length - 1;
            while (hi >= lo) {
                int mid = lo + (hi - lo) / 2;
                if      (numbers[mid] < key) lo = mid + 1;
                else if (numbers[mid] > key) hi = mid - 1;
                else return new int[] {i+1, mid+1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i;
        }
        for (int i = 197; i > 187; i--) {
            System.out.println(Arrays.toString(twoSum(a, i)));
        }
    }
}
