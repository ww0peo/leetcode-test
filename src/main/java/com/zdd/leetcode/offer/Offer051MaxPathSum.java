package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/3 15:05
 */
public class Offer051MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
