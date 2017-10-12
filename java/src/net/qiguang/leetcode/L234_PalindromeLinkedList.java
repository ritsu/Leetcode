package net.qiguang.leetcode;

import java.util.ArrayDeque;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class L234_PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // 2 ms ~33%
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // Split list in half
        ListNode last = head;
        ListNode mid = head;
        while (last != null && last.next != null) {
            last = last.next.next;
            mid = mid.next;
        }
        // Reverse last half of list
        ListNode tail = mid;
        last = mid.next;
        while (last != null) {
            ListNode tmp = last.next;
            last.next = tail;
            tail = last;
            last = tmp;
        }
        // Compare halves
        while (head != mid) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
    // 6 ms ~9%
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ListNode current = head;
        while (current != null) {
            q.addLast(current.val);
            current = current.next;
        }
        int mid = q.size() / 2;
        for (int i = 0; i < mid; i++) {
            if (!q.pollFirst().equals(q.pollLast()))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] a = {{1},
                {1,1},
                {1,2,1},
                {1,2,2,1},
                {1,2,3,1},
                {1,2,3,4,3,2,1},
                {1,2,3,4,4,3,2,1}};
        for (int i = 0; i < a.length; i++) {
            ListNode head = new ListNode(a[i][0]);
            ListNode current = head;
            for (int j = 1; j < a[i].length; j++) {
                current.next = new ListNode(a[i][j]);
                current = current.next;
            }
            System.out.println(isPalindrome(head));
        }
    }
}
