package com.zdd.leetcode.offer;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/MPnaiL
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @description:
 * @author: zdd
 * @time: 2022/1/21 17:56
 */
public class Offer014CheckInclusion {
    public static void main(String[] args) {
        Offer014CheckInclusion offer014CheckInclusion = new Offer014CheckInclusion();
        System.out.println(offer014CheckInclusion.checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int[] ints1 = new int[26];
        int[] ints2 = new int[26];
        byte[] bytes1 = s1.getBytes();
        byte[] bytes2 = s2.getBytes();
        for (int i = 0; i < s1.length(); i++) {
            ints1[bytes1[i] - 'a'] ++;
            ints2[bytes2[i] - 'a'] ++;
        }
        int diff = 0;
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] != ints2[i]){
                diff ++;
            }
        }
        if (diff == 0){
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            int y = bytes2[i] - 'a';
            int x = bytes2[i - s1.length()]  - 'a';
            if (x == y){
                continue;
            }
            if (ints1[x] == ints2[x]){
                diff ++;
            }
            if (ints1[y] == ints2[y]){
                diff ++;
            }
            ints2[x] --;
            ints2[y] ++;
            if (ints1[x] == ints2[x]){
                diff --;
            }
            if (ints1[y] == ints2[y]){
                diff --;
            }
            if (diff == 0){
                return true;
            }
        }
        return false;
    }
}
