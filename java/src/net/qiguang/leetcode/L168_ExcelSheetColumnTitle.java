package net.qiguang.leetcode;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *   1 -> A
 *   2 -> B
 *   3 -> C
 *   ...
 *   26 -> Z
 *   27 -> AA
 *   28 -> AB
 */
public class L168_ExcelSheetColumnTitle {
    // 0 ms ~6%
    public static String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return s.reverse().toString();
    }

    // 0 ms ~6%
    public static String convertToTitleRecursive(int n) {
        if (n == 0) return "";
        return convertToTitleRecursive((n - 1) / 26) + (char) ('A' + (n - 1) % 26);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            System.out.printf("%6d %6s\n", i, convertToTitle(i));
        }
    }
}
