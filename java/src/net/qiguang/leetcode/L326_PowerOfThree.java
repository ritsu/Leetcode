package net.qiguang.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class L326_PowerOfThree {
    // 17 ms ~87%
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0)
            n = n / 3;
        return n == 1;
    }
    // 22 ms ~16%
    public boolean isPowerOfThreeLog(int n) {
        if (n == 0) return false;
        double val = Math.log(n) / Math.log(3);
        return n == Math.pow(3, Math.round(val));
    }
    // 21 ms ~20%
    public boolean isPowerOfThreeMaxInt(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    // returns 1162261467
    public int getMaxPowerOfThree() {
        int n = Integer.MAX_VALUE;
        while (!isPowerOfThree(n))
            n--;
        return n;
    }
    public static void main(String[] args) {
        L326_PowerOfThree lc = new L326_PowerOfThree();
        for (int i = 0; i < 100; i++) {
            if (lc.isPowerOfThreeMaxInt(i))
                System.out.println(i);
        }
    }
}
