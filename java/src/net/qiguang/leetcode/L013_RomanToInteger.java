package net.qiguang.leetcode;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Symbol	I	V	X	L	C	D	M
 * Value	1	5	10	50	100	500	1,000
 */
public class L013_RomanToInteger {
    public static int romanToInt(String s) {
        int n = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if      (s.charAt(i) == 'I') n += n < 5 ? 1 : -1;
            else if (s.charAt(i) == 'V') n += 5;
            else if (s.charAt(i) == 'X') n += n < 50 ? 10 : -10;
            else if (s.charAt(i) == 'L') n += 50;
            else if (s.charAt(i) == 'C') n += n < 500 ? 100 : -100;
            else if (s.charAt(i) == 'D') n += 500;
            else if (s.charAt(i) == 'M') n += 1000;
        }
        return n;
    }
    public static void main(String[] args) {
        String[] rn = {"XXXIII"
                      ,"CXLVII"
                      ,"CCCLXV"
                      ,"XCIV"
                      ,"CCLXXXIX"
                      ,"LXXVIII"
                      ,"CCLVI"
                      ,"CCCXCV"
                      ,"CCXXVIII"
                      ,"MCMXCVII"
                      ,"CDLXXII"
                      ,"DCCCXCVIII"
                      ,"MMX"
                      ,"DCCLXIX"
                      ,"MMMDXLVIII"
                      ,"MMCMLXXI"};
        for (String s : rn) {
            System.out.printf("%12s %8d\n", s, romanToInt(s));
        }

    }
}
