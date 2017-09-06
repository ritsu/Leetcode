package net.qiguang.leetcode;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
 * elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively
 */
public class L088_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int sent1 = m - 1;
        int sent2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--)
            if (sent2 < 0 || (sent1 >= 0 && nums1[sent1] > nums2[sent2]))
                nums1[i] = nums1[sent1--];
            else
                nums1[i] = nums2[sent2--];
    }
    public static void mergeOMGLOOKHOWFEWLINESTHISHAS(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1, sent1 = m - 1, sent2 = n - 1; i >= 0; i--)
            nums1[i] = sent2 < 0 || (sent1 >= 0 && nums1[sent1] > nums2[sent2]) ? nums1[sent1--] : nums2[sent2--];
    }
    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n * 3];
        int[] b = new int[n];
        int[] c = new int[n];
        int vala = 0;
        int valb = 0;
        int valc = 0;
        for (int i = 0; i < n; i++) {
            vala += Math.random() * 10;
            valb += Math.random() * 10;
            valc += Math.random() * 10;
            a[i] = vala;
            b[i] = valb;
            c[i] = valc;
        }
        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));

        merge(a, n, b, n);
        System.out.println("Merge(A, B)");
        System.out.println("A: " + Arrays.toString(a));
        System.out.println("C: " + Arrays.toString(c));

        merge(a, n * 2, c, n);
        System.out.println("Merge(A, C)");
        System.out.println("A: " + Arrays.toString(a));
    }
}
