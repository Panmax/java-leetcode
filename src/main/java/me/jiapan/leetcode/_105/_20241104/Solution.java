package me.jiapan.leetcode._105._20241104;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public class TreeNode {
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

    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int root = preorder[preStart];
        int inRootIndex = indexMap.get(root);
        int leftSize = inRootIndex - inStart;
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = myBuildTree(preorder, inorder, preStart + 1, preStart + leftSize, inStart, inRootIndex - 1);
        rootNode.right = myBuildTree(preorder, inorder, preStart + leftSize + 1, preEnd, inRootIndex + 1, inEnd);
        return rootNode;
    }

}
