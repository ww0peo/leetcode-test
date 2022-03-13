package com.zdd.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/8 16:48
 */
public class Offer063ReplaceWords {

    public static void main(String[] args) {
        Offer063ReplaceWords offer063ReplaceWords = new Offer063ReplaceWords();
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        System.out.println(offer063ReplaceWords.replaceWords(list, "the cattle was rattled by the battery"));
    }
    
     class Trie {

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

        public String replaceWords(String word){
            byte[] bytes = word.getBytes();
            Trie trie = this;
            for (int i = 0; i < bytes.length; i++) {
                if (trie.children[bytes[i] - 'a'] == null){
                    return word;
                }
                trie = trie.children[bytes[i] - 'a'];
                if (trie.isEnd){
                    return word.substring(0, i + 1);
                }
            }
            return  word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(trie.replaceWords(str));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
