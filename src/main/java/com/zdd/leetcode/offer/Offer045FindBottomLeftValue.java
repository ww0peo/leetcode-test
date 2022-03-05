package com.zdd.leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/23 17:24
 */
public class Offer045FindBottomLeftValue {

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

    public int findBottomLeftValue(TreeNode root) {
        int ret = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            ret = deque.peek().val;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            while (!deque.isEmpty()){
                TreeNode node = deque.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            deque = queue;
        }
        return ret;
    }

}
