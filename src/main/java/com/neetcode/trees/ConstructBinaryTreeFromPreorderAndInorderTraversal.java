package com.neetcode.trees;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        return findRoot(preorder, inorder);
    }

    private TreeNode findRoot(int []preorder, int []inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        int rootIndexInInorder = 0;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == rootValue) rootIndexInInorder = i;
        }
        int []leftPreorder = new int[0];
        if (rootIndexInInorder > 0) { // rootIndexInInorder + 1 > 1
            leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndexInInorder + 1);
        }

        int []leftInorder = Arrays.copyOfRange(inorder, 0, rootIndexInInorder);
        TreeNode leftRoot = findRoot(leftPreorder, leftInorder);
        int []rightPreorder = new int[0];
        int []rightInorder = new int[0];
        if (len > rootIndexInInorder +1) {
            rightPreorder = Arrays.copyOfRange(preorder, rootIndexInInorder + 1, len);
            rightInorder = Arrays.copyOfRange(inorder, rootIndexInInorder + 1, len);
        }
        TreeNode rightRoot = findRoot(rightPreorder, rightInorder);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}
