package com.neetcode.trees;

public class InvertBinaryTree {
    // DFS recursion
    //
    // Main idea:
    // Swap left and right subtree recursively.
    //
    // Original:
    //         4
    //       /   \
    //      2     7
    //     / \   / \
    //    1   3 6   9
    //
    // Inverted:
    //         4
    //       /   \
    //      7     2
    //     / \   / \
    //    9   6 3   1
    //
    // Recursive flow:
    //
    // invert(4)
    // ├── left  = invert(7)
    // │   ├── left  = invert(9)
    // │   └── right = invert(6)
    // │
    // └── right = invert(2)
    //     ├── left  = invert(3)
    //     └── right = invert(1)
    //
    // Base case:
    // null node -> return null
    //
    // Time Complexity:
    // O(n)
    // Visit every node once
    //
    // Space Complexity:
    // O(h)
    // h = tree height
    // Worst case:
    // O(n) for skewed tree
    // O(log n) for balanced tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode(root.val);
        res.left = invertTree(root.right);
        res.right = invertTree(root.left);
        return res;
    }
}
