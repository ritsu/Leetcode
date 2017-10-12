package net.qiguang.leetcode;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */

public class L258_AddDigits {
    // 2 ms ~14%
    public int addDigits(int num) {
        int newnum = 0;
        while (num / 10 >= 1) {
            newnum += num % 10;
            num = num / 10;
        }
        newnum += num;
        if (newnum < 10)
            return newnum;
        return addDigits(newnum);
    }
    // 2 ms ~14% (congruence formula)
    public int addDigits2(int num) {
        return 1 + (num-1) % 9;
    }
    public static void main(String[] args) {
        L258_AddDigits lc = new L258_AddDigits();
        for (int n = 0; n < 100; n++)
            System.out.printf("%d %d\n", lc.addDigits(n), lc.addDigits2(n));
    }
}
