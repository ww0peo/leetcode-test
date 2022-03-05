package com.zdd.leetcode.offer;

import java.util.HashMap;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/20 17:40
 */
public class Offer011FindMaxLength {
    public static void main(String[] args) {
        Offer011FindMaxLength offer011FindMaxLength = new Offer011FindMaxLength();
        System.out.println(offer011FindMaxLength.findMaxLength(new int[]{0,1,0}));
    }

    public int findMaxLength(int[] nums) {
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                sum++;
            }else {
                sum--;
            }
            if (map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));
            }else {
                map.put(sum, i);
            }
        }
        return len;
    }
}
