package com.zdd.leetcode.offer;

import java.util.HashMap;
import java.util.Set;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/10 17:21
 */
public class Offer004SingleNumber {
    public static void main(String[] args) {
        Offer004SingleNumber offer004SingleNumber = new Offer004SingleNumber();
        System.out.println(offer004SingleNumber.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 100}));
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer value = map.get(i);
            if (value != null){
                map.put(i, ++value);
            }else {
                map.put(i, 1);
            }
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 依次确定每一个二进制位
     * @param nums
     * @return
     */
    public int singleNumber_1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
