package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/3 17:55
 */
public class Offer053InorderSuccessor {

    private boolean flag = false;

    private TreeNode node = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root.left != null){
            inorderSuccessor(root.left, p);
        }
        if (flag && node == null){
            node = root;
        }else if (flag){
            return node;
        }
        if (root.val == p.val){
            flag = true;
        }
        if (root.right != null){
            inorderSuccessor(root.right, p);
        }
        return node;
    }

}
