package com.zdd.leetcode.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/16 16:19
 */
public class Offer031LRUCache {


    class LRUCache {

        // 记录使用频率的链表
        LinkedList<Integer> session;
        HashMap<Integer, Integer> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            session = new LinkedList<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                map.put(key, value);

            }else {
            }
        }
    }
}
