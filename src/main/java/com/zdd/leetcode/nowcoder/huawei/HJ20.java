package com.zdd.leetcode.nowcoder.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 11:54
 */
public class HJ20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String pwd = scanner.nextLine();
            System.out.println(check(pwd));
        }
    }

    public static String check(String str){
        if (str.length() < 8){
            return "NG";
        }
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()){
            count ++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()){
            count ++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()){
            count ++;
        }
        Pattern p4 = Pattern.compile("[^A-Za-z0-9]");
        if (p4.matcher(str).find()){
            count ++;
        }
        if (count < 3){
            return "NG";
        }
        for (int i = 2; i < str.length(); i++) {
            if (str.substring(i + 1).contains(str.substring(i - 2, i + 1))){
                return "NG";
            }
        }
        return "OK";
    }

}
