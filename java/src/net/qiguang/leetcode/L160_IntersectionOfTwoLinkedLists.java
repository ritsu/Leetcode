package net.qiguang.leetcode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗
 * B:    b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class L160_IntersectionOfTwoLinkedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // Align
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA.next != null && curB.next != null) {
            curA = curA.next;
            curB = curB.next;
        }
        while (curB.next != null) {
            curB = curB.next;
            headB = headB.next;
        }
        while (curA.next != null) {
            curA = curA.next;
            headA = headA.next;
        }

        // Find match
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode currentA = a;
        ListNode currentB = b;
        for (int i = 1; i < 10; i++) {
            currentA.next = new ListNode(i);
            currentA = currentA.next;
            currentB.next = new ListNode(i);
            currentB = currentB.next;
        }
        currentB.next = currentA;

        System.out.println(getIntersectionNode(a, b).val);

        a = new ListNode(0);
        b = a;
        System.out.println(getIntersectionNode(a, b).val);

        a = new ListNode(0);
        b = new ListNode(0);
        System.out.println(getIntersectionNode(a, b));
    }
}
