package net.qiguang.leetcode;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has
 * (also known as the Hamming weight).
 *
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 */

public class L191_NumberOf1Bits {
    // 2 ms ~8%
    public static int hammingWeight(int n) {
        int ones = 0;
        for (int i = 0; i < 32; i++) {
            ones += n & 1;
            n >>>= 1;
        }
        return ones;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(hammingWeight(i));
        }
        System.out.println(hammingWeight(Integer.MAX_VALUE));
        System.out.println(hammingWeight(Integer.MIN_VALUE));
    }
}
