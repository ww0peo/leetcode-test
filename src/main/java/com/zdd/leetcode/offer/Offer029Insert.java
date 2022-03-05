package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/11 11:36
 */
public class Offer029Insert {
    public static void main(String[] args) {

    }

    public Node insert(Node head, int insertVal) {
        if (head == null){
            Node node = new Node();
            node.val = insertVal;
            node.next = node;
            return node;
        }
        if (head == head.next){
            Node node = new Node();
            node.val = insertVal;
            head.next = node;
            node.next = head;
            return head;
        }
        Node node = head;
        int min = Integer.MAX_VALUE;
        while (true){
            Node next = node.next;
            if (next.val > node.val && insertVal >= node.val && insertVal <= next.val){
                Node n = new Node();
                n.val = insertVal;
                node.next = n;
                n.next = next;
                return head;
            }
            if (next.val < node.val && (insertVal >= node.val || insertVal <= next.val)){
                Node n = new Node();
                n.val = insertVal;
                node.next = n;
                n.next = next;
                return head;
            }
            if (node == head && head.val == min){
                Node n = new Node();
                n.val = insertVal;
                node.next = n;
                n.next = next;
                return head;
            }
            min = Math.min(min, node.val);
            node = next;
        }
    }
}
