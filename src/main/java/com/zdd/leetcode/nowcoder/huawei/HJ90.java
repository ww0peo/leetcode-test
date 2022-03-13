package com.zdd.leetcode.nowcoder.huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 9:27
 */
public class HJ90 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.next();
        String[] ips = ip.split("\\.");
        if (ips.length != 4){
            System.out.println("NO");
        }else {
            boolean flag = false;
            String dict = "0123456789";
            for (String s : ips) {
                char[] chars = s.toCharArray();
                for (char aChar : chars) {
                    if (!dict.contains(String.valueOf(aChar))){
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
                if ("".equals(s) || (s.length() > 1 && s.charAt(0) == '0')){
                    System.out.println("NO");
                    flag = true;
                    break;
                }
                int i = Integer.parseInt(s);
                if (i < 0 || i > 255){
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println("YES");
            }
        }
    }
}
