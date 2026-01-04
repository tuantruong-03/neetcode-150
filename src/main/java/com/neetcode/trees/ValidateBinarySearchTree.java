package com.neetcode.trees;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode curr, Integer minConstraint, Integer maxConstraint) {
        if (curr == null) return true;
        int val = curr.val;
        if (minConstraint != null && val <= minConstraint) return false;
        if (maxConstraint != null && val >= maxConstraint) return false;
        return isValidBST(curr.left, minConstraint, val)
                && isValidBST(curr.right, val, maxConstraint);
    }
}
