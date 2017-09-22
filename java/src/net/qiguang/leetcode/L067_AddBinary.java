package net.qiguang.leetcode;

import java.util.Random;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class L067_AddBinary {
    // 5 ms ~27%
    public static String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        int carry = 0;
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            int x = (i > a.length()) ? 0 : Character.getNumericValue(a.charAt(a.length() - i));
            int y = (i > b.length()) ? 0 : Character.getNumericValue(b.charAt(b.length() - i));
            int bit = (x ^ y) ^ carry;
            carry = (x & y) | (x & carry) | (y & carry);
            s.append(bit);
        }
        if (carry > 0) s.append(carry);
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Random r = new Random();
            String b = "";
            String c = "";
            for (int j = 0; j < 10; j++) {
                b += r.nextInt(2);
                c += r.nextInt(2);
            }
            System.out.format("%13s\n", b);
            System.out.format("+%12s\n", c);
            System.out.format("=%12s\n", addBinary(b, c));
            System.out.format("=%12s\n\n",
                    Integer.toBinaryString(Integer.parseInt(b, 2) + Integer.parseInt(c, 2)));
        }
    }
}
