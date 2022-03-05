package com.zdd.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/1 17:58
 */
public class Offer050PathSum {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return getPath(root, map, 0, targetSum, 0);
    }

    public int getPath(TreeNode node, HashMap<Integer, Integer> map, int sum, int targetSum, int count){
        int current = sum;
        map.put(current, map.getOrDefault(current, 0) + 1);
        sum += node.val;
        count += map.getOrDefault(sum - targetSum, 0);
        if (node.left != null){
            count = getPath(node.left, map, sum, targetSum, count);
        }
        if (node.right != null){
            count = getPath(node.right, map, sum, targetSum, count);
        }
        map.put(current, map.get(current) - 1);
        return count;
    }
}
