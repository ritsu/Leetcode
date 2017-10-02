package net.qiguang.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class L231_PowerOfTwo {
    // 2 ms ~12%
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        while (n > 1) {
            if ((n & 1) > 0) return false;
            n >>>= 1;
        }
        return true;
    }
    // 2 ms ~12%
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
    public static void main(String[] args) {
        L231_PowerOfTwo lc = new L231_PowerOfTwo();
        for (int i = 0; i < 10000; i++)
            if (lc.isPowerOfTwo(i))
                System.out.println(i);
    }
}
