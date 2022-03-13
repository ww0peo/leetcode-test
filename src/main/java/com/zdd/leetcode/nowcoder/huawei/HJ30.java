package com.zdd.leetcode.nowcoder.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串合并处理
 *
 * @description:
 * @author: zdd
 * @time: 2022/3/12 11:59
 */
public class HJ30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            char[] chars1 = scanner.next().toCharArray();
            char[] chars2 = scanner.next().toCharArray();

            StringBuilder sb = new StringBuilder();
            sb.append(chars1);
            sb.append(chars2);

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (int i = 0; i < sb.length(); i++) {
                if (i%2 == 0){
                    sb1.append(sb.toString().charAt(i));
                }else {
                    sb2.append(sb.toString().charAt(i));
                }
            }

            chars1 = sb1.toString().toCharArray();
            chars2 = sb2.toString().toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (i%2 == 0){
                    stringBuilder.append(chars1[index]);
                }else {
                    stringBuilder.append(chars2[index]);
                    index ++;
                }
            }

            String dict = "0123456789abcdefABCDEF";
            char[] chars = stringBuilder.toString().toCharArray();
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (dict.contains(String.valueOf(chars[i]))){
                    // 当作16进制转换成10进制
                    int int1 = Integer.parseInt(String.valueOf(chars[i]), 16);
                    // 再转换成2进制
                    String s = Integer.toBinaryString(int1);
                    s = String.format("%04d", Integer.valueOf(s));
                    // 翻转
                    s = new StringBuilder(s).reverse().toString();
                    // 转换成2进制
                    int i1 = Integer.parseInt(s, 2);
                    String s1 = Integer.toString(i1, 16).toUpperCase();
                    chars[i] = s1.charAt(0);
                }
            }
            System.out.println(String.valueOf(chars));
        }
    }

}
