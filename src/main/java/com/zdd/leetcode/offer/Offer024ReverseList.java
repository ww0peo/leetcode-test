package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/6 11:25
 */
public class Offer024ReverseList {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode preNode = head;
        ListNode node = head.next;
        preNode.next = null;
        while (node != null){
            ListNode prePreNode = preNode;
            preNode = node;
            node = node.next;
            preNode.next = prePreNode;
        }
        return  preNode;
    }
}
