package net.qiguang.leetcode;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
public class L232_ImplementQueueUsingStacks {
    // 93 ms ~76%
    static class MyQueue {
        Stack<Stack> first;
        Stack<Stack> last;

        /** Initialize your data structure here. */
        public MyQueue() {
            first = new Stack<>();
            last = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            Stack<Integer> s = new Stack<>();
            s.push(x);
            if (first.isEmpty()) {
                first.push(s);
                last = first;
            } else {
                Stack<Stack> newlast = new Stack<>();
                newlast.push(s);
                s = last.pop();
                last.push(newlast);
                last.push(s);
                last = newlast;
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            Stack<Integer> s = first.pop();
            if (!first.isEmpty())
                first = first.pop();
            return s.pop();
        }

        /** Get the front element. */
        public int peek() {
            return (int) first.peek().peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return first.isEmpty();
        }
    }
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        for (int i = 0; i < 10; i++)
            q.push(i);
        System.out.println(q.peek());
        while (!q.empty())
            System.out.println(q.pop());
    }
}
