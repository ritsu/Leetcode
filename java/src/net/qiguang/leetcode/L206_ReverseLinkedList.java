package net.qiguang.leetcode;

/**
 * Reverse a singly linked list.
 */
public class L206_ReverseLinkedList {
    // 0 ms ~26%
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        return reverseList(next, head);
    }
    public ListNode reverseList(ListNode current, ListNode prev) {
        ListNode next = current.next;
        current.next = prev;
        if (next == null) return current;
        return reverseList(next, current);
    }

    // 0 ms ~26%
    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        ListNode prev =  null;
        ListNode next = current.next;
        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        return current;
    }

    public class ListNode {
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

    // Create list of ints [0, n)
    public ListNode getList(int n) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        L206_ReverseLinkedList lc = new L206_ReverseLinkedList();
        ListNode head = lc.getList(10);
        System.out.println(head);
        head = lc.reverseList(head);
        System.out.println(head);
    }
}
