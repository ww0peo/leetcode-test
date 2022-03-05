package com.zdd.leetcode.offer;

import java.util.HashSet;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/5 11:51
 */
public class Offer022DetectCycle {
    public static void main(String[] args) {

    }


    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        int len = 1;
        set.add(head);
        while (true){
            node = node.next;
            if (node == null){
                break;
            }else {
                set.add(node);
                if (len == set.size()){
                    return node;
                }
                len ++;
            }
        }
        return null;
    }
}
