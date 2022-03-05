package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/4 17:43
 */
public class Offer054ConvertBST {

    private int sum = 0;

    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node){
        if (node.right != null){
            dfs(node.right);
        }
        node.val = node.val + sum;
        sum = node.val;
        if (node.left != null){
            dfs(node.left);
        }
    }

}
