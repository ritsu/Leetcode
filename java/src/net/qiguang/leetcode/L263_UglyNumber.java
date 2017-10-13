package net.qiguang.leetcode;

/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 *
 * Note that 1 is typically treated as an ugly number.
 */
public class L263_UglyNumber {
    // 2 ms ~12%
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num = num / 2;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;
        return num == 1;
    }
    public static void main(String[] args) {
        L263_UglyNumber lc = new L263_UglyNumber();
        int count = 0;
        for (int n = 0; n < 100000; n++) {
            if (lc.isUgly(n))
                System.out.printf("%4d %6d\n", ++count, n);
        }
    }
}
