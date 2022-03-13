package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/10 16:18
 */
public class Offer068SearchInsert {

    public static void main(String[] args) {
        Offer068SearchInsert offer068SearchInsert = new Offer068SearchInsert();
        System.out.println(offer068SearchInsert.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target > nums[right]){
            return right + 1;
        }
        if (target < nums[left]){
            return 0;
        }
        if (target == nums[left]){
            return left;
        }
        if (target == nums[right]){
            return right;
        }
        return search(nums, target, left, right);
    }
    
    public int search(int[] nums, int target, int left, int right){
        if (left + 1 == right){
            return left + 1;
        }
        int middle = (left + right)/2;
        if (target == nums[middle]){
            return middle;
        }else if (target > nums[middle]){
            return search(nums, target, middle, right);
        }else {
            return search(nums, target, left, middle);
        }
    }

}
