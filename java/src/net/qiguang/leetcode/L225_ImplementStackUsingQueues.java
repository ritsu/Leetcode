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
 *
 * Note: Running time varied wildly for multiple submissions of the exact same code,
 *       anywhere from 96% to 6% for both implementations.
 */
public class L225_ImplementStackUsingQueues {
    // 86 ms ~96%, O(1)
    public class MyStack {
        ArrayDeque<ArrayDeque> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = null;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            ArrayDeque<ArrayDeque> old = queue;
            queue = new ArrayDeque<>();
            ArrayDeque<Integer> val = new ArrayDeque<>();
            val.add(x);
            queue.add(val);
            if (old != null) queue.add(old);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int val = (int) queue.poll().poll();
            queue = queue.poll();
            return val;
        }

        /** Get the top element. */
        public int top() {
            return (int) queue.peek().peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue == null;
        }
    }

    public MyStack getStack() {
        return new MyStack();
    }

    // 87 ms, 94% O(N) for push
    public class MyStack2 {
        ArrayDeque<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack2() {
            queue = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int s = queue.size();
            queue.add(x);
            while (s-- > 0)
                queue.add(queue.poll());
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public MyStack2 getStack2() {
        return new MyStack2();
    }

    public static void main(String[] args) {
        L225_ImplementStackUsingQueues lc = new L225_ImplementStackUsingQueues();
        MyStack2 s = lc.getStack2();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }
        System.out.println(s.top());
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
