package net.qiguang.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class L020_ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            else {
                if (st.isEmpty()) return false;
                else if (c == ')' && st.pop() != '(') return false;
                else if (c == ']' && st.pop() != '[') return false;
                else if (c == '}' && st.pop() != '{') return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String[] s1 = {"([{}])", "(){}[]", "(())[[]]{{}}", "(([]{})())"};
        String[] s2 = {"", "(", ")", "(()", "(}", "((("};

        for (String s : s1) {
            System.out.format("%12s: %s\n", s, isValid(s));
        }
        for (String s : s2) {
            System.out.format("%12s: %s\n", s, isValid(s));
        }
    }
}
