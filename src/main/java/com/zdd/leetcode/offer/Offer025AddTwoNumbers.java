package com.zdd.leetcode.offer;

import java.util.ArrayList;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/10 16:31
 */
public class Offer025AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> list1 = new ArrayList<>();
        ArrayList<ListNode> list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2);
            l2 = l2.next;
        }
        ListNode node = new ListNode();
        node.val = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        int cb = 0;
        for (int i = 0; i < size1 || i < size2; i++) {
            int sum = 0;
            sum += cb;
            if (i < size1) {
                sum += list1.get(size1 - i - 1).val;
            }
            if (i < size2) {
                sum += list2.get(size2 - i - 1).val;
            }
            node.val = sum % 10;
            cb = sum / 10;
            ListNode perNode = new ListNode();
            perNode.next = node;
            node = perNode;
        }
        if (cb == 0){
            return node.next;
        }else {
            node.val = cb;
            return node;
        }
    }
}
