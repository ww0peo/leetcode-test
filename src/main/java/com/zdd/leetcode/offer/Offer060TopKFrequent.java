package com.zdd.leetcode.offer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/6 11:07
 */
public class Offer060TopKFrequent {

    public static void main(String[] args) {
        Offer060TopKFrequent offer060TopKFrequent = new Offer060TopKFrequent();
        offer060TopKFrequent.topKFrequent(new int[]{3,0,0,1}, 1);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ints = new int[k];
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue())).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            ints[i] = list.get(i).getKey();
        }
        return ints;
    }

}
