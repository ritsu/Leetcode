package net.qiguang.leetcode;

import java.util.HashMap;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class L141_LinkedListCycle {
    // 1 ms ~10%
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode step = head;
        ListNode skip = head;
        while (skip.next != null && skip.next.next != null) {
            step = step.next;
            skip = skip.next.next;
            if (step == skip) return true;
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(null));

        ListNode nocycle1 = new ListNode(0);
        ListNode current = nocycle1;
        for (int i = 0; i < 100; i++) {
            ListNode n = new ListNode(i);
            current.next = n;
            current = n;
        }
        System.out.println(hasCycle(nocycle1));

        ListNode nocycle2 = new ListNode(0);
        System.out.println(hasCycle(nocycle2));

        ListNode cycle1 = new ListNode(0);
        cycle1.next = cycle1;
        System.out.println(hasCycle(cycle1));

        ListNode cycle2 = new ListNode(0);
        cycle2.next = new ListNode(1);
        cycle2.next.next = cycle2;
        System.out.println(hasCycle(cycle2));

        ListNode cycle3 = new ListNode(0);
        cycle3.next = new ListNode(1);
        cycle3.next.next = cycle3.next;
        System.out.println(hasCycle(cycle3));


    }
}
