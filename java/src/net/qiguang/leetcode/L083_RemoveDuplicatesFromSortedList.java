package net.qiguang.leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class L083_RemoveDuplicatesFromSortedList {
    // 1 ms ~11%
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val)
                current.next = current.next.next;
            current = current.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        // Create sorted list with random duplicates
        ListNode a = new ListNode(0);
        ListNode current = a;
        for (int i = 0; i < 100; i++) {
            while (Math.random() > 0.5) {
                ListNode next = new ListNode(i);
                current.next = next;
                current = next;
            }
        }
        // Print list
        current = a;
        while (current != null) {
            System.out.printf(current.val + " ");
            current = current.next;
        }
        System.out.println();
        // Check
        deleteDuplicates(a);
        current = a;
        while (current != null) {
            System.out.printf(current.val + " ");
            current = current.next;
        }
        System.out.println();

    }
}
