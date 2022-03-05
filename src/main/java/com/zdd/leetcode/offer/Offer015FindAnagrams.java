package com.zdd.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/24 16:28
 */
public class Offer015FindAnagrams {
    public static void main(String[] args) {
        Offer015FindAnagrams offer015FindAnagrams = new Offer015FindAnagrams();
        System.out.println(offer015FindAnagrams.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (p.length() > s.length()){
            return ret;
        }
        int[] ints1 = new int[26];
        int[] ints2 = new int[26];
        byte[] bytes1 = p.getBytes();
        byte[] bytes2 = s.getBytes();
        for (int i = 0; i < p.length(); i++) {
            ints1[bytes1[i] - 'a'] ++;
            ints2[bytes2[i] - 'a'] ++;
        }
        int diff = 0;
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] != ints2[i]){
                diff ++;
            }
        }
        if (diff == 0){
            ret.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            int y = bytes2[i] - 'a';
            int x = bytes2[i - p.length()]  - 'a';
            if (x == y){
                if (ret.contains(i - p.length())){
                    ret.add(i - p.length() + 1);
                }
                continue;
            }
            if (ints1[x] == ints2[x]){
                diff ++;
            }
            if (ints1[y] == ints2[y]){
                diff ++;
            }
            ints2[x] --;
            ints2[y] ++;
            if (ints1[x] == ints2[x]){
                diff --;
            }
            if (ints1[y] == ints2[y]){
                diff --;
            }
            if (diff == 0){
                ret.add(i - p.length() + 1);
            }
        }
        return ret;
    }
}
