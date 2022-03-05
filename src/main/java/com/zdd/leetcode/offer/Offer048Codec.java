package com.zdd.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/24 17:14
 */
public class Offer048Codec {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null){
                return "";
            }
            StringBuilder str = new StringBuilder();
            str.append(root.val);
            toStr(str, root);
            return str.toString();
        }

        public void toStr(StringBuilder str, TreeNode node){
            str.append(" ").append(node.left == null ? "null" : node.left.val);
            str.append(" ").append(node.right == null ? "null" : node.right.val);
            if (node.left != null){
                toStr(str, node.left);
            }
            if (node.right != null){
                toStr(str, node.right);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0){
                return null;
            }
            String[] nodeList = data.split(" ");
            ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(nodeList));
            TreeNode root = strToNode(deque.poll());
            toNode(deque, root);
            return root;
        }

        public void toNode(ArrayDeque<String> deque, TreeNode node){
            TreeNode left = strToNode(deque.poll());
            TreeNode right = strToNode(deque.poll());
            node.left = left;
            node.right = right;
            if (left != null){
                toNode(deque, left);
            }
            if (right != null){
                toNode(deque, right);
            }
        }

        public TreeNode strToNode(String str){
            if ("null".equals(str)){
                return null;
            }else {
                TreeNode node = new TreeNode();
                node.val = new Integer(str);
                return node;
            }
        }
    }
}
