package com.neetcode.trees;

public class LowestCommonAncestorOfABinarySearchTree {
    private TreeNode lowest;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (contains(root, p) && contains(root, q)) {
            lowest = root;
        }
        if (root.left != null) {
            lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            lowestCommonAncestor(root.right, p, q);
        }
        return lowest;
    }

    public boolean contains(TreeNode root, TreeNode want) {
        if (root == null) return false;
        if (root == want) return true;
        boolean rightContains = false;
        boolean leftContains = false;
        if (want.val > root.val) {
            rightContains = contains(root.right, want);
        } else {
            leftContains = contains(root.left, want);
        }
        return rightContains || leftContains;
    }
}
