package me.jiapan.leetcode._112._20240711;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> valNode = new LinkedList<>();
        queNode.offer(root);
        valNode.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.poll();
            int val = valNode.poll();
            if (node.left == null && node.right == null) {
                if (val == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queNode.offer(node.left);
                valNode.offer(val + node.left.val);
            }
            if (node.right != null) {
                queNode.offer(node.right);
                valNode.offer(val + node.right.val);
            }
        }
        return false;
    }
}
