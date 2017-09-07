package net.qiguang.leetcode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

public class L100_SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == q);
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println(isSameTree(new TreeNode(0), new TreeNode(0)));
        System.out.println(isSameTree(new TreeNode(0), new TreeNode(1)));
        System.out.println(isSameTree(new TreeNode(0), null));
        System.out.println(isSameTree(null, null));
    }


}
