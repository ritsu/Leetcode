package net.qiguang.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class L058_LengthOfLastWord {
    // 6 ms ~36%
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) == ' ') return s.length() - i - 1;
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello"));
        System.out.println(lengthOfLastWord(" Hello "));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord(""));
    }
}
