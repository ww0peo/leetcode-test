package com.zdd.leetcode.offer;

import java.util.ArrayList;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/4 11:51
 */
public class Offer021RemoveNthFromEnd {

    public static void main(String[] args) {
        Offer021RemoveNthFromEnd offer021RemoveNthFromEnd = new Offer021RemoveNthFromEnd();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        ListNode node = head.next;
        while (node != null){
            listNodes.add(node);
            node = node.next;
        }
        int index = listNodes.size() - n;
        if (n == 1){
            if (listNodes.size() > 1){
                ListNode listNode = listNodes.get(index - 1);
                listNode.next = null;
            }else {
                return null;
            }
        }else if (n == listNodes.size()){
            return listNodes.get(1);
        }else {
            listNodes.get(index - 1).next = listNodes.get(index + 1);
        }
        return head;
    }
}
