package com.zdd.leetcode.nowcoder.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 10:00
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        HashSet<Character> set = new HashSet<>();
        char[] chars = next.toCharArray();
        for (char aChar : chars) {
            set.add(aChar);
        }
        System.out.println(set.size());
    }
}
