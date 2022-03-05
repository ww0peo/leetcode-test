package com.zdd.leetcode.offer;

/**
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 *
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ZVAVXX
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: zdd
 * @time: 2022/1/17 16:00
 */
public class Offer009NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        Offer009NumSubarrayProductLessThanK offer009NumSubarrayProductLessThanK = new Offer009NumSubarrayProductLessThanK();
        System.out.println(offer009NumSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int count = 0;
        int total = 1;
        for (int end = 0; end < nums.length; end++) {
            total *= nums[end];
            while (end >= start && total >= k){
                total /= nums[start++];
            }
            if (start <= end){
                count += end - start + 1;
            }
        }
        return count;
    }
}
