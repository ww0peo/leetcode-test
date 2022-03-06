package com.zdd.leetcode.offer;

import java.util.HashSet;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/5 10:45
 */
public class Offer056FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    public boolean dfs(TreeNode node, int k, HashSet<Integer> set){
        if (set.contains(k - node.val)){
            return true;
        }
        set.add(node.val);
        if (node.left != null && dfs(node.left, k, set)){
            return true;
        }
        return node.right != null && dfs(node.right, k, set);
    }
}
