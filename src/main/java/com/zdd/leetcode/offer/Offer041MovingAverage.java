package com.zdd.leetcode.offer;

import java.util.ArrayDeque;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/22 16:13
 */
public class Offer041MovingAverage {

    public static void main(String[] args) {

    }

    public static class MovingAverage {

        private int size;

        private int sum;

        private ArrayDeque<Integer> deque;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            this.deque = new ArrayDeque<>(size);
            this.sum = 0;
        }

        public double next(int val) {
            if (deque.size() == size){
                sum -= deque.pollFirst();
                sum += val;
                deque.addLast(val);
                return (double) sum/size;
            }else {
                sum += val;
                deque.addLast(val);
                return (double) sum/deque.size();
            }
        }
    }
}
