package com.zdd.leetcode.offer;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/6 10:41
 */
public class Offer059KthLargest {

    class KthLargest {

        private PriorityQueue<Integer> pq;

        private int index;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                pq.add(nums[i]);
            }
            while (pq.size() > k){
                pq.poll();
            }
            index = k;
        }

        public int add(int val) {
            pq.add(val);
            while (pq.size() > index){
                pq.poll();
            }
            return pq.peek();
        }
    }

}
