package com.zdd.leetcode.offer;


/**
 * @description:
 * @author: zdd
 * @time: 2022/1/31 11:28
 */
public class Offer018IsPalindrome {

    public static void main(String[] args) {
        Offer018IsPalindrome offer018IsPalindrome = new Offer018IsPalindrome();
        System.out.println(offer018IsPalindrome.isPalindrome("ab_a"));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]*", "");
        byte[] bytes = s.getBytes();
        int length = bytes.length;
        for (int i = 0; i < (length + 1) / 2; i++) {
            if (bytes[i] != bytes[length - i - 1]){
                return false;
            }
        }
        return true;
    }

}
