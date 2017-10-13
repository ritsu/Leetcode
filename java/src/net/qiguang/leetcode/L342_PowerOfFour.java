package net.qiguang.leetcode;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class L342_PowerOfFour {
    // 2 ms ~14% (see L326_PowerOfThree for alternate solutions)
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        while (num % 4 == 0)
            num = num / 4;
        return num == 1;
    }
    public static void main(String[] args) {
        L342_PowerOfFour lc = new L342_PowerOfFour();
        for (int i = 0; i < 100; i++) {
            if (lc.isPowerOfFour(i))
                System.out.println(i);
        }
    }
}
