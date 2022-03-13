package com.zdd.leetcode.nowcoder.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 13:31
 */
public class HJ103 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] k = new int[ints.length];
        for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j]){
                    k[i] = Math.max(k[i], k[j] + 1);
                }
            }
        }
        Arrays.sort(k);
        System.out.println(k[k.length - 1] + 1);
    }

}
