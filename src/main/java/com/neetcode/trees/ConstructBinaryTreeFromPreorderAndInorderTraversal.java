package com.neetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build index map for inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(
                preorder, 0, preorder.length -1,
                inorder, 0, inorder.length - 1
        );
    }

    private TreeNode build(
            int[] preorder, int preorderStart, int preorderEnd,
            int[] inorder, int inorderStart, int inorderEnd
    ) {
        // Base case
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        int rootValue = preorder[preorderStart];
        int rootIndexInInorder = inorderMap.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int leftSize = rootIndexInInorder - inorderStart;
        root.left = build(preorder, preorderStart + 1, preorderStart + leftSize,
                inorder, inorderStart, rootIndexInInorder - 1);
        root.right = build(preorder, preorderStart + leftSize + 1, preorderEnd,
                inorder, rootIndexInInorder + 1, inorderEnd);
        return root;
    }
}
