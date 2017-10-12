package net.qiguang.leetcode;

import java.util.HashMap;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat"    , t = "car"    , return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class L242_ValidAnagram {
    // 6 ms ~67%
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--a[t.charAt(i)-'a'] < 0)
                return false;
        }
        return true;
    }
    // 43 ms ~16%
    public boolean isAnagramSlow(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) return false;
            int n = map.get(c);
            if (n == 1)
                map.remove(c);
            else
                map.put(c, n-1);
        }
        return true;
    }
    public static void main(String[] args) {
        L242_ValidAnagram lc = new L242_ValidAnagram();
        System.out.println(lc.isAnagram("anagram", "nagaram"));
        System.out.println(lc.isAnagram("rat", "car"));
    }
}
