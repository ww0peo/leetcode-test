package com.zdd.leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/23 17:30
 */
public class Offer046RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            list.add(deque.peekLast().val);
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
        return list;
    }

}
