package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/8 17:12
 */
public class Offer064MagicDictionary {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode","hallo"});
        System.out.println(magicDictionary.search("hello"));
    }

    static class MagicDictionary {

        private MagicDictionary[] children;

        private boolean isEnd;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            children = new MagicDictionary[26];
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                byte[] bytes = s.getBytes();
                MagicDictionary trie = this;
                for (int i = 0; i < bytes.length; i++) {
                    int index = bytes[i] - 'a';
                    if (trie.children[index] == null){
                        trie.children[index] = new MagicDictionary();
                    }
                    trie = trie.children[index];
                }
                trie.isEnd = true;
            }
        }

        public boolean search(String searchWord) {
            byte[] bytes = searchWord.getBytes();
            MagicDictionary trie = this;
            for (int i = 0; i < trie.children.length; i++) {
                if (trie.children[i] != null){
                    if (search(false, bytes, 0, trie.children[i], i)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(boolean flag, byte[] bytes, int index, MagicDictionary trie, int bit){
            if (bit != bytes[index] - 'a'){
                if (flag){
                    return false;
                }
                flag = true;
            }
            if (bytes.length - 1 <= index){
                return trie.isEnd && flag;
            }
            index ++;
            for (int i = 0; i < trie.children.length; i++) {
                if (trie.children[i] != null){
                    if (search(flag, bytes, index, trie.children[i], i)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
