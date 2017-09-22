package net.qiguang.leetcode;

import java.util.ArrayDeque;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 * Input: 4
 * Output: "1211"
 */
public class L038_CountAndSay {
    // 3 ms ~94%
    public static String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        char num = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != num) {
                sb.append(count).append(num);
                num = s.charAt(i);
                count = 0;
            }
            count++;
        }
        sb.append(count).append(num);
        return sb.toString();
    }
    public static String countAndSay(int n) {
        String s = "1";
        while (--n > 0) {
            s = countAndSay(s);
        }
        return s;
    }

    // 6 ms ~48%
    public static ArrayDeque<Integer> countAndSayQueue(ArrayDeque<Integer> r) {
        ArrayDeque<Integer> w = new ArrayDeque<Integer>();
        int num = r.poll();
        int count = 1;
        while (!r.isEmpty()) {
            int current = r.poll();
            if (current != num) {
                w.add(count);
                w.add(num);
                num = current;
                count = 0;
            }
            count++;
        }
        w.add(count);
        w.add(num);
        return w;
    }
    public static String countAndSayQueue(int n) {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(1);
        while (--n > 0) {
            q = countAndSayQueue(q);
        }
        StringBuilder s = new StringBuilder();
        while (!q.isEmpty()) {
            s.append(q.poll());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + ": " + countAndSay(i));
            System.out.println(i + ": " + countAndSayQueue(i));
        }
    }
}
