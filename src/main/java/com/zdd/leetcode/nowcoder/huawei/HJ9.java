package com.zdd.leetcode.nowcoder.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 12:19
 */
public class HJ9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!set.contains(chars[i])){
                sb.append(chars[i]);
                set.add(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }

}
