package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/7 17:55
 */
public class Offer062Trie {

    public static void main(String[] args) {
        Offer062Trie offer062Trie = new Offer062Trie();
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
    }

    static class Trie {

        private Trie[] children;

        private boolean isEnd;

        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            byte[] bytes = word.getBytes();
            Trie trie = this;
            for (int i = 0; i < bytes.length; i++) {
                int index = bytes[i] - 'a';
                if (trie.children[index] == null){
                    trie.children[index] = new Trie();
                }
                trie = trie.children[index];
            }
            trie.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            byte[] bytes = word.getBytes();
            Trie trie = this;
            for (byte aByte : bytes) {
                if (trie.children[aByte - 'a'] == null){
                    return false;
                }
                trie = trie.children[aByte - 'a'];
            }
            return  isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            byte[] bytes = prefix.getBytes();
            Trie trie = this;
            for (byte aByte : bytes) {
                if (trie.children[aByte - 'a'] == null){
                    return false;
                }
                trie = trie.children[aByte - 'a'];
            }
            return true;
        }
    }
}
