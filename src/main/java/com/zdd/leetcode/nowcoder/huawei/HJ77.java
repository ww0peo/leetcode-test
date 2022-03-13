package com.zdd.leetcode.nowcoder.huawei;

import java.util.*;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/13 10:35
 */
public class HJ77 {

    public static  ArrayList<String> ret = new ArrayList<>();

    public static String[] nums;

    public static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = Integer.parseInt(scanner.nextLine());
        nums = scanner.nextLine().split(" ");
        int index = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        dfs("", index, deque);
        Collections.sort(ret);
        for (String s : ret) {
            System.out.println(s);
        }
    }

    public static void dfs(String str, int index, Deque<Integer> deque){
        if (index < count){
            if (deque.isEmpty()){
                deque.addLast(Integer.parseInt(nums[index]));
                index ++;
                dfs(str, index, deque);
                deque.pollLast();
            }else {
                deque.addLast(Integer.parseInt(nums[index]));
                index ++;
                dfs(str, index, deque);
                deque.pollLast();
                index --;

                Integer num = deque.pollLast();
                if (str.equals("")){
                    dfs(str + num, index, deque);
                }else {
                    dfs(str + " " + num, index, deque);
                }
                deque.addLast(num);
            }
        }else {
            if (deque.isEmpty()){
                ret.add(str);
            }else {
                Integer num = deque.pollLast();
                if (str.equals("")){
                    dfs(str + num, index, deque);
                }else {
                    dfs(str + " " + num, index, deque);
                }
                deque.addLast(num);
            }
        }
    }

}
