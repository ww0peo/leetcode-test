package com.zdd.leetcode.offer;

import com.sun.deploy.util.StringUtils;

/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/JFETK5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @description:
 * @author: zdd
 * @time: 2022/1/6 17:34
 */
public class Offer002AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("101", "11"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int carryBit = 0;
        int lenA = a.length();
        int lenB = b.length();
        int maxLen = Math.max(lenA, lenB);
        for (int i = 0; i < maxLen; i++) {
            int sum = getInt(a,lenA - i - 1) + getInt(b,lenB - i - 1) + carryBit;
            switch (sum){
                case 0:
                    ret = ret.insert(0, "0");
                    carryBit = 0;
                    break;
                case 1:
                    ret = ret.insert(0, "1");
                    carryBit = 0;
                    break;
                case 2:
                    ret = ret.insert(0, "0");
                    carryBit = 1;
                    break;
                default:
                    ret = ret.insert(0, "1");
                    carryBit = 1;
            }
        }
        if (carryBit > 0){
            ret = ret.insert(0, "1");
        }
        return ret.toString();
    }

    public static int getInt(String str, int index){
        if (index >= 0){
            return (int) str.charAt(index) - 48;
        }
        return 0;
    }

}
