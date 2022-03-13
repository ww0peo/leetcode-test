package com.zdd.leetcode.nowcoder.huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 11:27
 */
public class HJ67 {

    public static boolean flag;
    public static boolean[] visit;
    public static String[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nums = scanner.nextLine().split(" ");
        visit = new boolean[4];
        for (int i = 0; i < 4; i++) {
            if (!visit[i]){
                visit[i] = true;
                dfs(1, Integer.parseInt(nums[i]));
                visit[i] = false;
            }
        }
        System.out.println(flag);
    }

    public static boolean dfs(int u, float sum){
        if (sum == 24 && u == 4){
            flag = true;
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (!visit[i]){
                visit[i] = true;
                if (dfs(u + 1, sum + Integer.parseInt(nums[i]))||
                        dfs(u + 1, sum - Integer.parseInt(nums[i]))||
                        dfs(u + 1, sum * Integer.parseInt(nums[i]))||
                        dfs(u + 1, sum / Integer.parseInt(nums[i]))){
                    return true;
                }
                visit[i] = false;
            }
        }
        return false;
    }
}
