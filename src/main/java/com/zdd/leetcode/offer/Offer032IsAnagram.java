package com.zdd.leetcode.offer;

import java.util.HashMap;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/16 17:40
 */
public class Offer032IsAnagram {
    public static void main(String[] args) {
        Offer032IsAnagram offer032IsAnagram = new Offer032IsAnagram();
        System.out.println(offer032IsAnagram.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return false;
        }
        byte[] sb = s.getBytes();
        byte[] tb = t.getBytes();
        HashMap<String, Integer> sMap = new HashMap<>();
        HashMap<String, Integer> tMap = new HashMap<>();
        for (byte b : sb) {
            sMap.put(b + "", sMap.getOrDefault(b + "", 0) + 1);
        }
        for (byte b : tb) {
            tMap.put(b + "", tMap.getOrDefault(b + "", 0) + 1);
        }
        if (sMap.equals(tMap)){
            return true;
        }
        return false;
    }
}
