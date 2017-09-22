package net.qiguang.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class L070_ClimbingStairs {
    // 0 ms ~9%
    // This is basically fibonacci because climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)
    public static int climbStairs(int n) {
        int c1 = 0;
        int c2 = 1;
        for (int i = 0; i < n; i++) {
            c2 = c2 + c1;
            c1 = c2 - c1;
        }
        return c2;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.printf("%2d: %4d\n", i, climbStairs(i));
        }
    }
}

