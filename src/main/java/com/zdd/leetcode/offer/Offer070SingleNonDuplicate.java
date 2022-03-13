package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/11 17:11
 */
public class Offer070SingleNonDuplicate {

    public static void main(String[] args) {
        Offer070SingleNonDuplicate offer070SingleNonDuplicate = new Offer070SingleNonDuplicate();
        System.out.println(offer070SingleNonDuplicate.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (right - left)/2 + left;
            mid = mid - (mid&1);
            if (nums[mid] == nums[mid + 1]){
                left = mid + 2;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }

}
