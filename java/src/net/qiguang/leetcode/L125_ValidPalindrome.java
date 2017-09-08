package net.qiguang.leetcode;

import java.util.Random;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class L125_ValidPalindrome {
    // Easy solution (beats 12% of submissions)
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9A-Za-z]", "").toLowerCase();
        if (s.length() <= 1) return true;
        String left = s.substring(0, s.length()/2);
        String right = s.substring(s.length() - s.length()/2, s.length());
        right = new StringBuilder(right).reverse().toString();
        return left.equals(right);
    }
    // Fast solution (beats 97% of submissions)
    public static boolean isPalindromeFast(String s) {
        for (int left = 0, right = s.length() - 1; right > left; right--, left++) {
            char a = s.charAt(left);
            char b = s.charAt(right);
            while (!isAlphaNumeric(a)) {
                if (++left >= s.length()) return true;
                a = s.charAt(left);
            }
            while (!isAlphaNumeric(b)) {
                if (--right < 0) return true;
                b = s.charAt(right);
            }
            if (a >= 'a' && a <= 'z') a -= 32;
            if (b >= 'a' && b <= 'z') b -= 32;
            if (a != b) return false;
        }
        return true;
    }
    public static boolean isAlphaNumeric(char c) {
        if      (c  < '0') return false;
        else if (c <= '9') return true;
        else if (c  < 'A') return false;
        else if (c <= 'Z') return true;
        else if (c  < 'a') return false;
        else if (c <= 'z') return true;
        return false;
    }

    public static void main(String[] args) {
        String[] ss = {"", "a", "aa", "asa", ".a", "a.", ".a.", "a.a", "a.sa", ".asa", ".."};
        for (String s : ss) {
            System.out.printf("%8s: %s %s\n", s, isPalindrome(s), isPalindromeFast(s));
        }

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            String s = "";
            char c;
            for (int j = 0; j < 10; j++) {
                // Add chars
                int set = r.nextInt(3);
                if      (set == 0) c = (char) (r.nextInt('9' - '0') + '0');
                else if (set == 1) c = (char) (r.nextInt('Z' - 'A') + 'A');
                else               c = (char) (r.nextInt('z' - 'a') + 'a');
                s = c + s + c;
                // Add non-alphanumeric chars
                if (r.nextInt(10) == 0) s = s + (char) (r.nextInt('/' - ' ') + ' ');
                if (r.nextInt(10) == 0) s = (char) (r.nextInt('/' - ' ') + ' ') + s;
                // Not a palindrome
                if (r.nextInt(20) == 0) s += c;
            }
            System.out.printf("%28s: %s %s\n", s, isPalindrome(s), isPalindromeFast(s));
        }
    }
}
