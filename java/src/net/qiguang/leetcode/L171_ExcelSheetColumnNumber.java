package net.qiguang.leetcode;

/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28
 */
public class L171_ExcelSheetColumnNumber {
    // 2 ms ~35%
    public static int titleToNumber(String s) {
        int num = 0;
        int p = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += (s.charAt(i) - 'A' + 1) * p;
            p *= 26;
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("B"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AYK"));

    }
}
