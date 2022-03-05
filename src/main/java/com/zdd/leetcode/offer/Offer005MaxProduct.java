package com.zdd.leetcode.offer;

/**
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2:
 *
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *  
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aseY1I
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: zdd
 * @time: 2022/1/11 17:22
 */
public class Offer005MaxProduct {
    public static void main(String[] args) {
        Offer005MaxProduct offer005MaxProduct = new Offer005MaxProduct();
        System.out.println(offer005MaxProduct.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"}));
        System.out.println(offer005MaxProduct.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(offer005MaxProduct.maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }
    public int maxProduct(String[] words) {
        int[] wordCode = init(words);
        int maxLength = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words.length - i; j++) {
                if ((wordCode[i]&wordCode[i+j]) == 0){
                    if (words[i].length()*words[i+j].length() > maxLength){
                        maxLength = words[i].length()*words[i+j].length();
                    }
                }
            }
        }
        return maxLength;
    }
    public int[] init(String[] words){
        int[] ret = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                ret[i] |= 1 << (c-'a');
            }
        }
        return ret;
    }
}
