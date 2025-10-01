package com.neetcode.trees;

public class BalancedBinaryTree {
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = 1 + depth(root.left);
        int rightDepth = 1 + depth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + depth(root.left);
        int right = 1 + depth(root.right);
        return Math.max(left, right);
    }

    public boolean isBalanced2(TreeNode root) {
        return check(root) != -1; // if -1 means unbalanced
    }

    private int check(TreeNode root) {
        if (root == null) return 0; // depth = 0

        int left = check(root.left);
        if (left == -1) return -1;  // left subtree not balanced

        int right = check(root.right);
        if (right == -1) return -1; // right subtree not balanced

        if (Math.abs(left - right) > 1) return -1; // current node not balanced

        return 1 + Math.max(left, right); // return depth if balanced
    }

}
