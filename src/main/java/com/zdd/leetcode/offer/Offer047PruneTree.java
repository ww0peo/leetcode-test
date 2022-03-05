package com.zdd.leetcode.offer;

import java.util.ArrayDeque;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/24 16:19
 */
public class Offer047PruneTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(0);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode2.left = treeNode4;
        Offer047PruneTree offer047PruneTree = new Offer047PruneTree();
        System.out.println(offer047PruneTree.pruneTree(treeNode1));
    }

    public TreeNode pruneTree(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        getAllNode(root, deque);
        while (!deque.isEmpty()){
            TreeNode node = deque.pollLast();
            if (node.left != null && isRemove(node.left)){
                node.left = null;
            }
            if (node.right != null && isRemove(node.right)){
                node.right = null;
            }
        }
        if (root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }

    public void getAllNode(TreeNode node, ArrayDeque<TreeNode> deque){
        deque.add(node);
        if (node.left != null){
            getAllNode(node.left, deque);
        }
        if (node.right != null){
            getAllNode(node.right, deque);
        }
    }

    public boolean isRemove(TreeNode node){
        if (node.val == 1){
            return false;
        }
        if (node.left != null && !isRemove(node.left)){
            return false;
        }
        if (node.right != null){
            return isRemove(node.right);
        }
        return true;
    }


}
