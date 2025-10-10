package com.neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null ) return List.of();
        int depth = depth(root);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= depth; i++) {
            res.add(new ArrayList<>());
        }
        levelOrderRecur(root, 0 , res);
        return res;
    }

    private void levelOrderRecur(TreeNode curr, int level, List<List<Integer>> res) {
        if (curr == null) return;
        res.get(level).add(curr.val);
        levelOrderRecur(curr.left, level + 1, res);
        levelOrderRecur(curr.right, level + 1, res);
    }


    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null) {
            left = 1 + depth(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = 1 + depth(root.right);
        }
        return Math.max(left,right);
    }


    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
