package com.zdd.leetcode.offer;

import java.util.HashSet;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/6 11:17
 */
public class Offer023GetIntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (true){
            set.add(node);
            if (node.next == null){
                break;
            }
            node = node.next;
        }
        int size = set.size();
        node = headB;
        while (true){
            set.add(node);
            if (size == set.size()){
                return node;
            }
            size ++;
            if (node.next == null){
                break;
            }
            node = node.next;
        }
        return null;
    }

}
