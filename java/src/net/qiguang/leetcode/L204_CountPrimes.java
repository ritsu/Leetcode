package net.qiguang.leetcode;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class L204_CountPrimes {
    // 12ms ~97%
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] a = new boolean[n];
        int count = n/2;
        int max = (int) Math.sqrt(n-1);
        for (int i = 3; i <= max; i += 2) {
            if (a[i]) continue;
            for (int j = i*i; j < n; j += 2*i) {
                if (!a[j]) {
                    a[j] = true;
                    count--;
                }
            }
        }
        return count;
    }

    // 19ms ~95%
    public int countPrimes2(int n) {
        if (n < 3) return 0;
        boolean[] a = new boolean[n];
        int count = 1;
        int max = (int) Math.sqrt(n-1);
        for (int i = 3; i < n; i += 2) {
            if (!a[i]) count++;
            if (i > max) continue;
            for (int j = i*i; j < n; j += 2*i) {
                a[j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        L204_CountPrimes ex = new L204_CountPrimes();
        int prev = 0;
        for (int i = 0; i < 100; i++) {
            int count = ex.countPrimes(i);
            System.out.printf("%4d %4d", i, count);
            if (count > prev) System.out.printf(" %4d", i - 1);
            prev = count;
            System.out.println();
        }
    }
}
