package com.zdd.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/21 14:40
 */
public class Offer039LargestRectangleArea {
    public static void main(String[] args) {
        Offer039LargestRectangleArea offer039LargestRectangleArea = new Offer039LargestRectangleArea();
        System.out.println(offer039LargestRectangleArea.largestRectangleArea(new int[]{2, 0, 5, 6, 0, 7}));
    }

//    public int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
//        int are = 0;
//        stack.push(-1);
//        for (int i = 0; i < heights.length; i++) {
//            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]){
//                are = Math.max(are, heights[stack.pop()] * (i - stack.peek() - 1));
//            }
//            stack.push(i);
//        }
//        while (stack.peek() != -1){
//            are = Math.max(are, heights[stack.pop()] * (heights.length - stack.peek() - 1));
//        }
//        return are;
//    }

    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int are = 0;
        deque.addLast(-1);
        for (int i = 0; i < heights.length; i++) {
            while (deque.peekLast() != -1 && heights[i] <= heights[deque.peekLast()]){
                are = Math.max(are, heights[deque.pollLast()] * (i - deque.peekLast() - 1));
            }
            deque.addLast(i);
        }
        while (deque.peekLast() != -1){
            are = Math.max(are, heights[deque.pollLast()] * (heights.length - deque.peekLast() - 1));
        }
        return are;
    }
}
