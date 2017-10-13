package net.qiguang.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single space.
 */
public class L290_WordPattern {
    // 1 ms ~96%
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<String, Integer> map = new HashMap<>();
        String[] ships = new String[26];
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int c = pattern.charAt(i) - 'a';
            if (ships[c] != null) {
                if (!ships[c].equals(w))
                    return false;
            }
            else {
                ships[c] = w;
            }
            if (map.containsKey(words[i])) {
                if (!map.get(words[i]).equals(c))
                    return false;
            }
            else
                map.put(words[i], c);
        }
        return true;
    }
    // 2 ms ~25%
    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != (map.put(words[i], i)))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        L290_WordPattern lc = new L290_WordPattern();
        System.out.println(lc.wordPattern("abba", "dog cat cat dog"));
        System.out.println(lc.wordPattern("abba", "dog cat cat fish"));
        System.out.println(lc.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(lc.wordPattern("abba", "dog dog dog dog"));
    }
}
