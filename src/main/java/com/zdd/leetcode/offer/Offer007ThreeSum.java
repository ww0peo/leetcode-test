package com.zdd.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1fGaJU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: zdd
 * @time: 2022/1/13 17:23
 */
public class Offer007ThreeSum {
    public static void main(String[] args) {
        Offer007ThreeSum offer007ThreeSum = new Offer007ThreeSum();
        System.out.println(offer007ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && i < left){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    right --;
                    left ++;
                }else if (sum > 0){
                    right --;
                }else {
                    left ++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
