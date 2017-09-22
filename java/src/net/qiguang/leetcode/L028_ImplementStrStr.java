package net.qiguang.leetcode;

/**
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 */
public class L028_ImplementStrStr {
    // 7 ms ~72%
    public static int strStr(String haystack, String needle) {
        int h = needle.hashCode();
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; i++) {
            if (haystack.substring(i, i + needle.length()).hashCode() == h) return i;
        }
        return -1;
    }

    // 6 ms ~88%, I mean, it's a solution.
    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.format("1234,   123, %2d\n", strStr("1234", "123"));
        System.out.format("1234,   123, %2d\n", "1234".indexOf("123"));
        System.out.format("1234,     4, %2d\n", strStr("1234", "4"));
        System.out.format("1234,     4, %2d\n", "1234".indexOf("4"));
        System.out.format("1234,  1234, %2d\n", strStr("1234", "1234"));
        System.out.format("1234,  1234, %2d\n", "1234".indexOf( "1234"));
        System.out.format("1234, 12345, %2d\n", strStr("1234", "12345"));
        System.out.format("1234, 12345, %2d\n", "1234".indexOf("12345"));
        System.out.format("1234,      , %2d\n", strStr("1234", ""));
        System.out.format("1234,      , %2d\n", "1234".indexOf(""));
        System.out.format("    ,      , %2d\n", strStr("", ""));
        System.out.format("    ,      , %2d\n", "".indexOf(""));
    }
}

