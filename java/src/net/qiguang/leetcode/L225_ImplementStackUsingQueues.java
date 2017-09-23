package net.qiguang.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 *   push(x) -- Push element x onto stack.
 *   pop()   -- Removes the element on top of the stack.
 *   top()   -- Get the top element.
 *   empty() -- Return whether the stack is empty.
 *
 * Notes:
 *   You must use only standard operations of a queue -- which means only
 *     push to back,
 *     peek/pop from front,
 *     size, and
 *     is empty
 *   operations are valid.
 *
 *   Depending on your language, queue may not be supported natively. You may simulate a queue by using
 *   a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 *
 *   You may assume that all operations are valid (for example, no pop or top operations will be called
 *   on an empty stack).
 */
public class L225_ImplementStackUsingQueues {
    // 88 ms ~91%
    public class MyStack {
        ArrayDeque<ArrayDeque> first;

        /** Initialize your data structure here. */
        public MyStack() {
            first = null;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            ArrayDeque<ArrayDeque> oldfirst = first;
            first = new ArrayDeque<ArrayDeque>();
            ArrayDeque<Integer> firstval = new ArrayDeque<Integer>();
            firstval.add(x);
            first.add(firstval);
            if (oldfirst != null) first.add(oldfirst);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int val = (int) first.poll().poll();
            first = first.poll();
            return val;
        }

        /** Get the top element. */
        public int top() {
            ArrayDeque<Integer> tmp = first.peek();
            return tmp.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return first == null;
        }
    }

    public MyStack getStack() {
        return new MyStack();
    }

    public static void main(String[] args) {
        L225_ImplementStackUsingQueues lc = new L225_ImplementStackUsingQueues();
        MyStack s = lc.getStack();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }
        System.out.println(s.top());
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
