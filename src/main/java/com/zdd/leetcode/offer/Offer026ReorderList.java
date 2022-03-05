package com.zdd.leetcode.offer;

import java.util.ArrayList;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/10 17:19
 */
public class Offer026ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int size = list.size();
        int middle = size / 2;
        if (size <= 1){
            return;
        }
        head = list.get(0);
        int i = 1;
        while (true){
            head.next = list.get(size - i);
            head = list.get(size - i);
            if (size - i == middle){
                break;
            }
            head.next = list.get(i);
            head = list.get(i);
            if (i == middle){
                break;
            }
            i ++;
        }
        head.next = null;
    }
}
