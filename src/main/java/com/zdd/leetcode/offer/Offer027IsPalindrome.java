package com.zdd.leetcode.offer;

import java.util.ArrayList;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/11 10:47
 */
public class Offer027IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        for (int i = 0; i < (list.size() + 1)/2; i++) {
            if (list.get(i).val != list.get(list.size() - i - 1).val){
                return false;
            }
        }
        return true;
    }
}
