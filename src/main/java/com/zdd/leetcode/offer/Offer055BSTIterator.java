package com.zdd.leetcode.offer;

import java.util.ArrayList;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/4 17:56
 */
public class Offer055BSTIterator {

    class BSTIterator {

        private ArrayList<Integer> list;

        private TreeNode root;

        private int index;

        public BSTIterator(TreeNode root) {
            this.root = root;
            list = new ArrayList<>();
            index = 0;
            dfs(root);
        }

        public void dfs(TreeNode node){
            if (node.left != null){
                dfs(node.left);
            }
            list.add(node.val);
            if (node.right != null){
                dfs(node.right);
            }
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            if (index >= list.size()){
                return false;
            }
            return true;
        }
    }
}
