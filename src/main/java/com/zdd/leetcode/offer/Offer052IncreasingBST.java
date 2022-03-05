package com.zdd.leetcode.offer;

import java.util.ArrayList;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/3 17:30
 */
public class Offer052IncreasingBST {

    private ArrayList<TreeNode> nodes = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root.left != null){
            increasingBST(root.left);
        }
        TreeNode node = new TreeNode(root.val);
        if (!nodes.isEmpty()){
            TreeNode treeNode = nodes.get(nodes.size() - 1);
            treeNode.right = node;
        }
        nodes.add(node);
        if (root.right != null){
            increasingBST(root.right);
        }
        return nodes.get(0);
    }
}
