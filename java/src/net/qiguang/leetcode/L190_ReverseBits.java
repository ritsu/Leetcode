package net.qiguang.leetcode;

import java.util.Random;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */

public class L190_ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r = r << 1 | (n & 1);
            n >>>= 1;
        }
        return r;
    }
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int n = i;
            System.out.println(Integer.toBinaryString(n));
            System.out.println(Integer.toBinaryString(reverseBits(n)));
            System.out.println(Integer.toBinaryString(reverseBits(reverseBits(n))));
            System.out.println();
        }
    }
}
