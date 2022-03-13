package com.zdd.leetcode.nowcoder.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 10:03
 */
public class HJ88 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        System.out.println(helper(next));
    }

    public static String helper(String str){
        HashMap<String, Integer> map = new HashMap<>(15);
        map.put("3",1);
        map.put("4",2);
        map.put("5",3);
        map.put("7",4);
        map.put("8",5);
        map.put("9",6);
        map.put("10",7);
        map.put("J",8);
        map.put("Q",9);
        map.put("K",10);
        map.put("A",11);
        map.put("2",12);
        map.put("joker",13);
        map.put("JOKER",14);
        String[] pokes = str.split("-");
        String poke1 = pokes[0];
        String poke2 = pokes[1];
        String[] poke1s = poke1.split(" ");
        String[] poke2s = poke2.split(" ");
        if (poke1s.length == 2 && "joker".equals(poke1s[0]) && "JOKER".equals(poke1s[1])){
            return poke1;
        }
        if (poke2s.length == 2 && "joker".equals(poke2s[0]) && "JOKER".equals(poke2s[1])){
            return poke2;
        }
        if (poke1s.length != poke2s.length && poke1s.length != 4 && poke2s.length != 4){
            return "ERROR";
        }
        switch (poke1s.length){
            case 1:
            case 2:
            case 3:
            case 5:
                if (poke2s.length == 4){
                    return poke2;
                }
                return map.get(poke1s[0]) > map.get(poke2s[0]) ? poke1 : poke2;
            case 4:
                if (poke2s.length == 4){
                    return map.get(poke1s[0]) > map.get(poke2s[0]) ? poke1 : poke2;
                }else {
                    return poke1;
                }
            default:
                return "ERROR";
        }
    }
}
