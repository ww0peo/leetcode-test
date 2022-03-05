package com.zdd.leetcode.offer;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/22 16:22
 */
public class Offer042RecentCounter {

    class RecentCounter {

        private ArrayDeque<Integer> deque;

        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.addLast(t);
            int time = t - 3000;
            while (deque.peekFirst() < time){
                deque.pollFirst();
            }
            return deque.size();
        }
    }

}
