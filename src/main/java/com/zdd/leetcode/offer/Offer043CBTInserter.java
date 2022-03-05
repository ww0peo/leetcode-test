package com.zdd.leetcode.offer;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/22 16:47
 */
public class Offer043CBTInserter {

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

    class CBTInserter {

        private final TreeNode root;

        private final Queue<TreeNode> deque;

        private boolean isLeft;

        public CBTInserter(TreeNode root) {
            this.root = root;
            deque = new ArrayDeque<>();
            deque.add(root);
            while (!deque.isEmpty()){
                TreeNode node = deque.peek();
                if (node.left != null){
                    deque.add(node.left);
                }else {
                    isLeft = true;
                    break;
                }
                if (node.right != null){
                    deque.add(node.right);
                }else {
                    isLeft = false;
                    deque.poll();
                    break;
                }
            }
        }

        public int insert(int v) {
            TreeNode peek = deque.peek();
            TreeNode node = new TreeNode();
            node.val = v;
            if (isLeft){
                peek.left = node;
            }else {
                peek.right = node;
                deque.poll();
            }
            deque.add(node);
            isLeft = !isLeft;
            return peek.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
