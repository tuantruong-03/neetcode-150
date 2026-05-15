package com.neetcode.trees;

import java.util.*;
public class TreeTraversal {

    // =========================================================
    // PREORDER DFS
    // Root -> Left -> Right
    //
    // Example:
    //         1
    //       /   \
    //      2     3
    //     / \
    //    4   5
    //
    // Output:
    // [1, 2, 4, 5, 3]
    // =========================================================
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderDfs(root, res);
        return res;
    }

    private void preorderDfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        preorderDfs(node.left, res);
        preorderDfs(node.right, res);
    }

    // =========================================================
    // INORDER DFS
    // Left -> Root -> Right
    //
    // BST inorder traversal gives sorted order
    //
    // Example:
    // [4, 2, 5, 1, 3]
    // =========================================================
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderDfs(root, res);
        return res;
    }

    private void inorderDfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        inorderDfs(node.left, res);
        res.add(node.val);
        inorderDfs(node.right, res);
    }

    // =========================================================
    // POSTORDER DFS
    // Left -> Right -> Root
    //
    // Useful for deleting/freeing tree
    //
    // Example:
    // [4, 5, 2, 3, 1]
    // =========================================================
    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderDfs(root, res);
        return res;
    }

    private void postorderDfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        postorderDfs(node.left, res);
        postorderDfs(node.right, res);
        res.add(node.val);
    }

    // =========================================================
    // LEVEL ORDER BFS
    //
    // Traverse level by level using Queue
    //
    // Example:
    // [
    //   [1],
    //   [2, 3],
    //   [4, 5]
    // ]
    // =========================================================
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();
                level.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            res.add(level);
        }

        return res;
    }
}
