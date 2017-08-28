package net.qiguang.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class L009_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int len = (int) Math.floor(Math.log10(x));
        while (x > 0) {
            int a = x % 10;
            int b = (int) Math.pow(10, len);
            if (a != x / b) return false;
            x = (x - a * b) / 10;
            len -= 2;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 10, 11, 123, 121, 1234, 1221, 12345, 12321, 123456, 123321, -12321, 2147447412, 1000021};
        for (int i : nums) {
            System.out.format("%12d %s\n", i, isPalindrome(i));
        }
    }
}
