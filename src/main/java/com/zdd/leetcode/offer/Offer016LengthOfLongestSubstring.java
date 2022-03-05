package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/24 16:36
 */
public class Offer016LengthOfLongestSubstring {

    public static void main(String[] args) {
        Offer016LengthOfLongestSubstring offer016LengthOfLongestSubstring = new Offer016LengthOfLongestSubstring();
        System.out.println(offer016LengthOfLongestSubstring.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 1;
        int start = 0;
        int end = 1;
        byte[] bytes = s.getBytes();
        int[] ints = new int[95];
        ints[bytes[start] - ' '] ++;
        int diff = 0;
        while (end < s.length()){
            if (diff == 0){
                maxLen = Math.max(maxLen, end - start);
                ints[bytes[end] - ' '] ++;
                if (ints[bytes[end] - ' '] > 1){
                    diff ++;
                }
                end ++;
                if (diff == 0){
                    maxLen = Math.max(maxLen, end - start);
                }
            }else {
                ints[bytes[start] - ' '] --;
                if (ints[bytes[start] - ' '] == 1){
                    diff --;
                }
                start ++;

            }
        }
        return maxLen;
    }

}
