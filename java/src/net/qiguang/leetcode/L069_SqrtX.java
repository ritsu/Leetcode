package net.qiguang.leetcode;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class L069_SqrtX {
    // Track number of iterations
    public static int count_newton = 0;
    public static int count_binary = 0;

    // 2 ms, ~62%, Binary search
    public static int mySqrtBinary(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        return mySqrtBinary(x, 0, x);
    }
    public static int mySqrtBinary(int x, int lo, int hi) {
        count_binary++;
        int mid = lo + (hi - lo) / 2;
        if (x / mid == mid) return mid;
        if (x / mid > mid) {
            if (x / (mid + 1) < (mid + 1)) return mid;
            return mySqrtBinary(x, mid + 1, hi);
        }
        else {
            return mySqrtBinary(x, lo, mid - 1);
        }
    }

    // 3 ms ~13%, Newton's method
    public static int mySqrt(int x) {
        long sqrt = x;
        while (sqrt * sqrt > x) {
            count_newton++;
            sqrt = (sqrt + x / sqrt) / 2;
        }
        return (int) sqrt;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.printf("Sqrt(%d) = %d %d\n", i, mySqrt(i), mySqrtBinary(i));
        }
        for (int i = 101; i < 100000; i++) {
            mySqrt(i);
            mySqrtBinary(i);
        }
        System.out.printf("      Newton: %8d\n", count_newton);
        System.out.printf("BinarySearch: %8d\n", count_binary);
    }
}
