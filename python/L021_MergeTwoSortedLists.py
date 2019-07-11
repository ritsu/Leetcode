"""
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
"""

import random


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        items = ListNode.toList(self)
        return " -> ".join([str(item) for item in items])

    def fromList(items: list) -> "ListNode":
        first = ListNode(items[-1])
        for item in reversed(items[:-1]):
            cur = first
            first = ListNode(item)
            first.next = cur
        return first

    def toList(node: "ListNode") -> list:
        l = [node.val]
        while node.next is not None:
            node = node.next
            l.append(node.val)
        return l


class L021_MergeTwoSortedLists:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        """ Recursive version """
        if l1 is None:
            return l2
        if l2 is None:
            return l1

        if l1.val < l2.val:
            merged = l1
            l1 = l1.next
        else:
            merged = l2
            l2 = l2.next
        merged.next = self.mergeTwoLists(l1, l2)
        return merged

    def mergeTwoLists2(self, l1: ListNode, l2: ListNode) -> ListNode:
        """ Non-recursive version """
        if l1 is None:
            return l2
        if l2 is None:
            return l1

        if l1.val < l2.val:
            first = l1
            l1 = l1.next
        else:
            first = l2
            l2 = l2.next

        cur = first
        while True:
            if l1 is None:
                cur.next = l2
                return first
            if l2 is None:
                cur.next = l1
                return first
            
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next


def main():
    obj = L021_MergeTwoSortedLists()

    # Given example
    l1 = ListNode.fromList([1, 2, 4])
    l2 = ListNode.fromList([1, 3, 4])

    print(f"List 1: {l1}")
    print(f"List 2: {l2}")
    print(f"Merged: {obj.mergeTwoLists(l1, l2)}")
    
    # Random tests
    for i in range(10):
        l1 = [random.randint(0, 9) for i in range(random.randint(1, 10))]
        l1.sort()
        l1 = ListNode.fromList(l1)
        l2 = [random.randint(0, 9) for i in range(random.randint(1, 10))]
        l2.sort()
        l2 = ListNode.fromList(l2)
        print()
        print(f"List 1: {l1}")
        print(f"List 2: {l2}")
        print(f"Merged: {obj.mergeTwoLists(l1, l2)}")


if __name__ == "__main__":
    main()
