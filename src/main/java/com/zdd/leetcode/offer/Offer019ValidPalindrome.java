package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/1 11:36
 */
public class Offer019ValidPalindrome {

    public static void main(String[] args) {
        Offer019ValidPalindrome offer019ValidPalindrome = new Offer019ValidPalindrome();
        System.out.println(offer019ValidPalindrome.validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        byte[] bytes = s.getBytes();
        int length = bytes.length;
        int left = 0;
        int right = length - 1;
        while (left < right){
            if (bytes[left] != bytes[right]){
                return isPalindrome(bytes, left + 1, right) || isPalindrome(bytes, left, right - 1);
            }
            left ++;
            right --;
        }
        return true;
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
