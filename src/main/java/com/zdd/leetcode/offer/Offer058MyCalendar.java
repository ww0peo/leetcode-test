package com.zdd.leetcode.offer;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/6 10:20
 */
public class Offer058MyCalendar {

    class MyCalendar {

        private TreeSet<Integer> set;
        HashMap<Integer, Integer> map;

        public MyCalendar() {
            set = new TreeSet<>();
            map = new HashMap<>();
        }

        public boolean book(int start, int end) {
            if (set.size() > 0){
                Integer floor = set.floor(start);
                if (floor != null && map.get(floor) > start){
                    return false;
                }
                Integer ceiling = set.ceiling(start);
                if (ceiling != null && ceiling < end){
                    return false;
                }
            }
            set.add(start);
            map.put(start, end);
            return true;
        }
    }

}
