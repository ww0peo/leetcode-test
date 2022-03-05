package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/11 11:00
 */
public class Offer028Flatten {
    public static void main(String[] args) {

    }
    public Node flatten(Node head) {
        Node ret = head;
        while (head != null){
            Node next = head.next;
            Node finalNode = getFinalNode(head);
            if (finalNode != null){
                finalNode.next = next;
                if (next != null){
                    next.prev = finalNode;
                }
            }else {
                head  = next;
            }
        }
        return ret;
    }

    public Node getFinalNode(Node node){
        Node child = node.child;
        if (child == null){
            return null;
        }
        node.next = child;
        child.prev = node;
        node.child = null;
        Node ret = null;
        while (child != null){
            ret = child;
            Node next = child.next;
            Node finalNode = getFinalNode(child);
            if (finalNode != null){
                finalNode.next = next;
                if (next != null){
                    next.prev = finalNode;
                }
            }else {
                child  = next;
            }
        }
        return ret;
    }
}
