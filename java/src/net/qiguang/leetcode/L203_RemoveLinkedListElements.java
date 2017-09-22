package net.qiguang.leetcode;

import java.util.Random;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
class L203_RemoveLinkedListElements {
    // 1 ms ~52%
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);

        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            current.next = next;
            current = next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public String toString() {
            ListNode current = this;
            StringBuilder sb = new StringBuilder();
            while (current != null) {
                sb.append(current.val + " ");
                current = current.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int listsize = 20;
        int maxval = 10;

        // Create list
        ListNode head = new ListNode(0);
        ListNode current = head;
        Random r = new Random();
        for (int i = 1; i < listsize; i++) {
            current.next = new ListNode(r.nextInt(maxval));
            current = current.next;
        }
        System.out.printf("%4s %s\n", "", head);

        // Remove random items
        while (head != null) {
            int val = r.nextInt(maxval);
            head = removeElements(head, val);
            System.out.printf("[%2d] %s\n", val, head);
        }
    }
}
