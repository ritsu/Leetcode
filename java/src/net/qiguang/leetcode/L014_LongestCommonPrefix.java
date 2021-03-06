package net.qiguang.leetcode;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class L014_LongestCommonPrefix {
    // 10 ms ~73%
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length - 1];
        int max = Math.min(a.length(), b.length());
        int i = 0;
        while (i < max && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return a.substring(0, i);
    }
    public static void main(String[] args) {
        String[] s0 = new String[0];
        System.out.println("s0: " + longestCommonPrefix(s0));
        String[] s1 = {""};
        System.out.println("s1: " + longestCommonPrefix(s1));
        String[] s2 = {"a"};
        System.out.println("s2: " + longestCommonPrefix(s2));
        String[] s3 = {"", "a"};
        System.out.println("s3: " + longestCommonPrefix(s3));
        String[] s4 = {"a", "b"};
        System.out.println("s4: " + longestCommonPrefix(s4));
        String[] s5 = {"aa", "a"};
        System.out.println("s5: " + longestCommonPrefix(s5));
        String[] s6 = {"a", "aa"};
        System.out.println("s6: " + longestCommonPrefix(s6));
        String[] s7 = {"aa", "aa"};
        System.out.println("s7: " + longestCommonPrefix(s7));
    }
}
