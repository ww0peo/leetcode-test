package com.zdd.leetcode.nowcoder.huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 12:30
 */
public class HJ107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double v = scanner.nextDouble();
        System.out.println(String.format("%.1f", dfs(v)));
    }

    public static double dfs(double num){
        if (num == 0){
            return 0;
        }
        double left = 0;
        double right = 0;
        double mid = 0;
        if (num > 0){
            if (num < 1){
                right = 1;
            }else {
                right = num;
            }
        }else {
            if (num > -1){
                left = -1;
            }else {
                left = num;
            }
        }
        while (right - left > 0.001){
            mid = (right + left)/2;
            if (mid * mid * mid > num){
                right = mid;
            }else if (mid*mid*mid < num){
                left = mid;
            }else {
                return mid;
            }
        }
        return right;
    }

}
