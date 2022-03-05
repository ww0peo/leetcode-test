package com.zdd.leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/23 17:00
 */
public class Offer044LargestValues {

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

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int max = Integer.MIN_VALUE;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            while (!deque.isEmpty()){
                TreeNode node = deque.poll();
                max = Math.max(max, node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(max);
            deque = queue;
        }
        return list;
    }
}
