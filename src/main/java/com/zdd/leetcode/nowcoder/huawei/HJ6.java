package com.zdd.leetcode.nowcoder.huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 12:48
 */
public class HJ6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        double k = Math.sqrt(l);
        for (int i = 2; i <= k ; i++) {
            while (l%i == 0){
                System.out.print(i + " ");
                l /= i;
            }
        }
        if (l != 1){
            System.out.print(l);
        }
    }

}
