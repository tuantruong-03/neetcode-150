package com.neetcode.trees;


public class CountGoodNodesInBinaryTree {
    private int ans;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        ans = 1;
        maxFromRootToCurrentNode(root.left, root.val);
        maxFromRootToCurrentNode(root.right, root.val);
        return ans;
    }

    private void maxFromRootToCurrentNode(TreeNode node, int currentMax) {
        if (node == null) {
            return;
        }
        int max = currentMax;
        if (node.val >= currentMax) {
            ans++;
            max = node.val;
        }
        maxFromRootToCurrentNode(node.left, max);
        maxFromRootToCurrentNode(node.right, max);
    }
}
