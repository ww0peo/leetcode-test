package com.zdd.leetcode.offer;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 *
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *  
 *
 * 说明 :
 *
 * 0 <= n <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/w3tCBm
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description:
 * @author: zdd
 * @time: 2022/1/10 15:59
 */
public class Offer003CountBits {
    public static void main(String[] args) {
        for (int i : countBits(10)) {
            System.out.println(i);
        }
    }

    public static int[] countBits(int n) {
        int[] ret = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ret[i] = countOnes(i);
//            ret[i] = Integer.bitCount(i);
        }
        return  ret;
    }

    public static int countOnes(int x){
        int ones = 0;
        while (x > 0){
            x &= (x - 1);
            ones ++;
        }
        return  ones;
    }


    /**
     * 动态规划——最高有效位
     * @param n
     * @return
     */
    public int[] countBits01(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    /**
     * 动态规划——最低有效位
     * @param n
     * @return
     */
    public int[] countBits02(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

}
