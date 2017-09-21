package net.qiguang.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order
 * of characters. No two characters may map to the same character but a character may map to itself.
 *
 * For example,
 *   Given "egg", "add", return true.
 *   Given "foo", "bar", return false.
 *   Given "paper", "title", return true.
 *
 * Note:
 * You may assume both s and t have the same length.
 */
public class L205_IsomorphicStrings {
    // 7ms ~90%
    public boolean isIsomorphic(String s, String t) {
        int[] sa = new int[128];
        int[] ta = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i);
            int tc = t.charAt(i);
            if (sa[sc] > 0 || ta[tc] > 0) {
                if (sa[sc] != tc) return false;
            } else {
                sa[sc] = tc;
                ta[tc] = sc;
            }
        }
        return true;
    }

    // 20ms ~49%
    public boolean isIsomorphicHash(String s, String t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            int b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b)
                    return false;
            } else if (map.containsValue(b)) {
                return false;
            } else {
                map.put(a, b);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L205_IsomorphicStrings ex = new L205_IsomorphicStrings();
        String[][] pairs = {{"egg", "add"}, {"foo", "bar"}, {"paper", "title"}, {"aa", "ab"}, {"ab", "aa"}};
        for (String[] pair : pairs) {
            System.out.println(ex.isIsomorphic(pair[0], pair[1]));
        }
    }
}
