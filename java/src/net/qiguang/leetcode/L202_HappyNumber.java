package net.qiguang.leetcode;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in
 * a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *   1^2 + 9^2 = 82
 *   8^2 + 2^2 = 68
 *   6^2 + 8^2 = 100
 *   1^2 + 0^2 + 0^2 = 1
 */
public class L202_HappyNumber {
    // 2 ms ~80%
    public boolean isHappy(int n) {
        int slow = happySum(n);
        int fast = happySum(slow);
        while (slow != fast) {
            slow = happySum(slow);
            fast = happySum(fast);
            fast = happySum(fast);
        }
        return slow == 1;
    }
    public int happySum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappyHash(int n) {
        HashSet<Integer> h = new HashSet<>();
        while (h.contains(n) == false) {
            h.add(n);
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        L202_HappyNumber lc = new L202_HappyNumber();
        for (int i = 0; i < 1000; i++) {
            System.out.printf("%5d %s\n", i, lc.isHappy(i));
        }
    }
}
