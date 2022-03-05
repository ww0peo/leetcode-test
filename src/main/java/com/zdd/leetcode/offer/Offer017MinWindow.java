package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/29 11:09
 */
public class Offer017MinWindow {
    public static void main(String[] args) {
        Offer017MinWindow offer017MinWindow = new Offer017MinWindow();
        System.out.println(offer017MinWindow.minWindow("cabwefgewcwaefgcf", "cae"));
    }
    public String minWindow(String s, String t) {
        String minStr = "";
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = -1;
        int[] ints1 = new int[128];
        int[] ints2 = new int[128];
        byte[] bytes1 = t.getBytes();
        byte[] bytes2 = s.getBytes();
        int diff = 0;
        for (int i = 0; i < bytes1.length; i++) {
            if (ints1[bytes1[i]] == 0){
                diff ++;
            }
            ints1[bytes1[i]] ++;
        }
        while (true){
            if (diff != 0){
                if (right >= bytes2.length - 1){
                    break;
                }
                right ++;
                if (ints1[bytes2[right]] > 0){
                    ints2[bytes2[right]] ++;
                    if (ints1[bytes2[right]] == ints2[bytes2[right]]){
                        diff --;
                    }
                }
            }else {
                if (minLen > right - left){
                    minLen = right - left;
                    minStr = s.substring(left, right + 1);
                }
                if (left >= right){
                    break;
                }
                if (ints1[bytes2[left]] > 0){
                    if (ints1[bytes2[left]] == ints2[bytes2[left]]){
                        diff ++;
                    }
                    ints2[bytes2[left]] --;
                }
                left ++;
            }
        }
        return minStr;
    }
}
