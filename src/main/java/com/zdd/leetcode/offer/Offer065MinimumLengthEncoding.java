package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/9 16:24
 */
public class Offer065MinimumLengthEncoding {

    public static void main(String[] args) {
        Offer065MinimumLengthEncoding offer065MinimumLengthEncoding = new Offer065MinimumLengthEncoding();
        System.out.println(offer065MinimumLengthEncoding.minimumLengthEncoding(new String[]{"t"}));
    }

    class Trie {

        private Trie[] children;

        private boolean isEnd;

        public int count;

        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
            count = 0;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            byte[] bytes = word.getBytes();
            Trie trie = this;
            for (int i = bytes.length - 1; i >= 0; i--) {
                int index = bytes[i] - 'a';
                if (trie.children[index] == null){
                    trie.children[index] = new Trie();
                }
                trie = trie.children[index];
            }
            trie.isEnd = true;
        }

        public void calculate(){
            Trie trie = this;
            calculate(trie, 1);
        }

        public void calculate(Trie trie, int len){
            boolean isEmpty = true;
            for (int i = 0; i < trie.children.length; i++) {
                if (trie.children[i] != null){
                    isEmpty = false;
                    calculate(trie.children[i], len + 1);
                }
            }
            if (isEmpty&&trie.isEnd){
                count += len;
            }
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        trie.calculate();
        return trie.count;
    }

}
