package com.zdd.leetcode.offer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/18 16:40
 */
public class Offer038DailyTemperatures {
    public static void main(String[] args) {
        Offer038DailyTemperatures offer038DailyTemperatures = new Offer038DailyTemperatures();
        for (int i : offer038DailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {
            System.out.println(i);
        }
    }

//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] ret = new int[temperatures.length];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
//                Integer pop = stack.pop();
//                ret[pop] = i - pop;
//            }
//            stack.push(i);
//        }
//        return ret;
//    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]){
                Integer pop = deque.pollLast();
                ret[pop] = i - pop;
            }
            deque.addLast(i);
        }
        return ret;
    }
}
