package com.neetcode.trees;

public class DiameterOfBinaryTree {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxVertexDepth(root);
        return diameter;
    }
    private int maxVertexDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = 1 + maxVertexDepth(root.left);
        }
        if (root.right != null) {
            right = 1 + maxVertexDepth(root.right);
        }
        // Update max diameter: left depth + right depth at the current node
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right);
    }
}
