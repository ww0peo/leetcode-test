package com.zdd.leetcode.offer;

import java.util.HashSet;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/9 17:21
 */
public class Offer067FindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        int HIGH_BIT = 30;
        int x = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            HashSet<Integer> set = new HashSet<>();
            for (int i1 = 0; i1 < nums.length; i1++) {
                set.add(nums[i1] >> i);
            }
            x = x*2 + 1;
            boolean flag = false;
            for (Integer k : set) {
                if (set.contains(k ^ x)){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                x = x - 1;
            }
        }
        return x;
    }

}
