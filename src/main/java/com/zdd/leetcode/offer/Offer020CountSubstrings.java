package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/1 11:54
 */
public class Offer020CountSubstrings {
    public static void main(String[] args) {
        Offer020CountSubstrings offer020CountSubstrings = new Offer020CountSubstrings();
        System.out.println(offer020CountSubstrings.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        byte[] bytes = s.getBytes();
        int count = 0;
        count += bytes.length;
        for (int i = 1; i < bytes.length; i++) {
            int left = 0;
            int right = i;
            while (right < bytes.length){
                if (isPalindrome(bytes, left, right)) {
                    count ++;
                }
                left ++;
                right ++;
            }
        }
        return count;
    }

    public boolean isPalindrome(byte[] bytes, int left, int right) {
        while (left < right){
            if (bytes[left] != bytes[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
