package com.neetcode.trees;

public class KthSmallestElementInOneBST {
    private int index = 1;
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k);
    }

    private int inOrder(TreeNode root, int k) {
       if (root == null) return -1;
       int left = inOrder(root.left, k);
       if (left != -1) return left;
       if (index == k) return root.val;
       index++;
       return inOrder(root.right, k);
    }
}
