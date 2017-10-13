package net.qiguang.leetcode;

/**
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */
public class L344_ReverseString {
    // 2 ms ~75%
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int mid = c.length / 2;
        for (int i = 0; i < mid; i++) {
            char tmp = c[i];
            c[i] = c[c.length - i - 1];
            c[c.length - i - 1] = tmp;
        }
        return String.valueOf(c);
    }
    // 4 ms ~28%
    public String reverseStringTrivial(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        L344_ReverseString lc = new L344_ReverseString();
        String s = "hello";
        System.out.printf("%s %s\n", s, lc.reverseString(s));
    }
}
