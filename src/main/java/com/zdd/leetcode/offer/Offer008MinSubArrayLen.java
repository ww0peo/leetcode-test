package com.zdd.leetcode.offer;

import java.util.Arrays;

/**
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2VG8Kg
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: zdd
 * @time: 2022/1/17 15:00
 */
public class Offer008MinSubArrayLen {

    public static void main(String[] args) {
        Offer008MinSubArrayLen offer008MinSubArrayLen = new Offer008MinSubArrayLen();
        System.out.println(offer008MinSubArrayLen.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 1;
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        while (end <= nums.length){
            int sum = sums[end] - sums[start];
            if (sum >= target){
                ans = Math.min(ans, end-start);
            }
            if (sum > target && start < (end-1)){
                start ++;
            }else {
                end ++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
