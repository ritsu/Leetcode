package net.qiguang.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class L021_MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        // For visualization
        public String toString() {
            StringBuilder s = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                s.append(current.val).append(" ");
                current = current.next;
            }
            return s.toString();
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode root;
        if (l1.val < l2.val) {
            root = l1;
            root.next = mergeTwoLists(l1.next, l2);
        }
        else {
            root = l2;
            root.next = mergeTwoLists(l1, l2.next);
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode prev = l1;
        for (int i = 2; i < 20; i += 2) {
            ListNode tmp = new ListNode(i);
            prev.next = tmp;
            prev = tmp;
        }
        ListNode l2 = new ListNode(1);
        prev = l2;
        for (int i = 3; i < 20; i += 2) {
            ListNode tmp = new ListNode(i);
            prev.next = tmp;
            prev = tmp;
        }
        System.out.format("L1: %s\n", l1);
        System.out.format("L2: %s\n", l2);
        System.out.format("mergeTwoLists(L1, L2): %s\n", mergeTwoLists(l1, l2));
    }
}
