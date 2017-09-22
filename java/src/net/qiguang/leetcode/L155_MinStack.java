package net.qiguang.leetcode;

import java.util.ArrayDeque;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *   push(x)   Push element x onto stack.
 *   pop()     Removes the element on top of the stack.
 *   top()     Get the top element.
 *   getMin()  Retrieve the minimum element in the stack.
 *
 * Example:
 *   MinStack minStack = new MinStack();
 *   minStack.push(-2);
 *   minStack.push(0);
 *   minStack.push(-3);
 *   minStack.getMin();   --> Returns -3.
 *   minStack.pop();
 *   minStack.top();      --> Returns 0.
 *   minStack.getMin();   --> Returns -2.
 */
public class L155_MinStack {
    // 98 ms ~96%
    public static class MinStack {
        ArrayDeque<Integer> d;

        public MinStack()   { d = new ArrayDeque<>(); }
        public void push(int x) {
            int min = d.isEmpty() ? x : Math.min(x, d.peekLast());
            d.addFirst(x);
            d.addLast(min);
        }
        public void pop() {
            d.removeFirst();
            d.removeLast();
        }
        public int top()    { return d.peekFirst(); }
        public int getMin() { return d.peekLast();  }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
