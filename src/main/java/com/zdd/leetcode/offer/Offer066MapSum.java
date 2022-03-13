package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/9 17:04
 */
public class Offer066MapSum {

    class MapSum {

        public MapSum[] children;

        public int val;

        /** Initialize your data structure here. */
        public MapSum() {
            children = new MapSum[26];
            val = 0;
        }

        public void insert(String key, int val) {
            byte[] bytes = key.getBytes();
            MapSum trie = this;
            for (int i = 0; i < bytes.length; i++) {
                int index = bytes[i] - 'a';
                if (trie.children[index] == null){
                    trie.children[index] = new MapSum();
                }
                trie = trie.children[index];
            }
            trie.val = val;
        }

        public int sum(String prefix) {
            byte[] bytes = prefix.getBytes();
            MapSum trie = this;
            for (byte aByte : bytes) {
                if (trie.children[aByte - 'a'] == null){
                    return 0;
                }
                trie = trie.children[aByte - 'a'];
            }
            return sum(trie, 0);
        }

        public int sum(MapSum trie, int sum){
            sum += trie.val;
            for (int i = 0; i < trie.children.length; i++) {
                if (trie.children[i] != null){
                    sum = sum(trie.children[i], sum);
                }
            }
            return sum;
        }
    }

}
