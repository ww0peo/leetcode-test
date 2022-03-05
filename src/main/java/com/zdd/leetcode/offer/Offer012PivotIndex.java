package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/21 16:00
 */
public class Offer012PivotIndex {

    public static void main(String[] args) {
        Offer012PivotIndex offer012PivotIndex = new Offer012PivotIndex();
        System.out.println(offer012PivotIndex.pivotIndex(new int[]{1, 2, 3}));
    }

    public int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] == sums[nums.length] - sums[i+1]){
                return i;
            }
        }
        return -1;
    }

}
