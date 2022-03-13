package com.zdd.leetcode.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/7 16:22
 */
public class Offer061KSmallestPairs {

    public static void main(String[] args) {
        Offer061KSmallestPairs offer061KSmallestPairs = new Offer061KSmallestPairs();
        System.out.println(offer061KSmallestPairs.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        for (int i = 0; i < Math.min(k, m * n); i++) {
            int[] poll = pq.poll();
            lists.add(new ArrayList<Integer>(){{
                add(nums1[poll[0]]);
                add(nums2[poll[1]]);
            }});
            if (poll[1] + 1 < n){
                pq.offer(new int[]{poll[0],poll[1] + 1});
            }
        }
        return lists;
    }

}
