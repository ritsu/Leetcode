package net.qiguang.leetcode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 * (silly question imho)
 */
public class L237_DeleteNodeInALinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public String toString() {
            ListNode current = this;
            StringBuilder sb = new StringBuilder();
            while (current != null) {
                sb.append(current.val).append(" ");
                current = current.next;
            }
            return sb.toString();
        }
    }
    // 1 ms ~3%
    public static void deleteNode(ListNode node) {
        if (node.next == null) return;
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode toDelete = head;
        for (int i = 1; i < 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
            if (i == 5) toDelete = current;
        }
        System.out.println(head);
        deleteNode(toDelete);
        System.out.println(head);
    }
}
