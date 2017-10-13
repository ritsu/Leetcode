package net.qiguang.leetcode;

import java.util.Random;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class L278_FirstBadVersion {
    private boolean[] isBad;
    private L278_FirstBadVersion(int n, int bad) {
        isBad = new boolean[n+1];
        isBad[0] = false;
        for (int i = 1; i < n; i++)
            isBad[i] = i >= bad;
    }
    private boolean isBadVersion(int n) {
        return isBad[n];
    }
    // 17 ms ~53%
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid))
                hi = mid;
            else
                lo = mid + 1;
        }
        return hi;
    }
    // 21 ms ~13%
    public int firstBadVersion2(int n) {
        int lo = 1;
        int hi = n;
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid))
                lo = mid + 1;
            else if (isBadVersion(mid-1))
                hi = mid - 1;
            else
                return mid;
        }
        return hi;
    }
    public static void main(String[] args) {
        int n = 100;
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt(n) + 1;
            L278_FirstBadVersion lc = new L278_FirstBadVersion(n, r);
            System.out.printf("%4d %4d\n", r, lc.firstBadVersion(n));
        }
    }
}
