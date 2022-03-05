package com.zdd.leetcode.offer;

import java.security.Key;
import java.util.*;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/17 16:43
 */
public class Offer033GroupAnagrams {

    public static void main(String[] args) {
        Offer033GroupAnagrams offer033GroupAnagrams = new Offer033GroupAnagrams();
        offer033GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> lists = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.computeIfAbsent(getKey(str), key -> new ArrayList<>()).add(str);
        }
        map.forEach((key, value) -> lists.add(value));
        return lists;
    }

    public String getKey(String str){
        byte[] bytes = str.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

}
