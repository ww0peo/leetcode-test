package com.zdd.leetcode.offer;

import java.util.HashMap;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/17 17:06
 */
public class Offer010SubarraySum {
    public static void main(String[] args) {
        Offer010SubarraySum offer010SubarraySum = new Offer010SubarraySum();
        System.out.println(offer010SubarraySum.subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum , map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
