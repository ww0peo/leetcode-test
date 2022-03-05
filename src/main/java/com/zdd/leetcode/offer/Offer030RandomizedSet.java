package com.zdd.leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/15 11:30
 */
public class Offer030RandomizedSet {

    public static void main(String[] args) {
//        RandomizedSet randomizedSet = new Offer030RandomizedSet().RandomizedSet();
//        randomizedSet.insert(1);
//        randomizedSet.insert(2);
    }

    class RandomizedSet {

        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;
        private Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }else {
                map.put(val, list.size());
                list.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int i = list.get(list.size() - 1);
                list.set(list.size() - 1, val);
                list.set(map.get(val), i);
                map.put(i, map.get(val));
                list.remove(list.size() - 1);
                map.remove(val);
                return true;
            }else {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

}
