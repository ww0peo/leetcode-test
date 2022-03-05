package com.zdd.leetcode.offer;

import java.util.ArrayDeque;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/21 15:59
 */
public class Offer040MaximalRectangle {

    public static void main(String[] args) {
        Offer040MaximalRectangle offer040MaximalRectangle = new Offer040MaximalRectangle();
        System.out.println(offer040MaximalRectangle.maximalRectangle(new String[]{"1"}));
    }

    public int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length();
        int are = 0;
        int[][] mtx = new int[row][col];
        for (int i = 0; i < row; i++) {
            String rows = matrix[i];
            for (int j = 0; j < col; j++) {
                mtx[i][j] = new Integer(rows.substring(j, j+1));
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            int[] heights = new int[col];
            for (int j = 0; j < col; j++) {
                heights[j] = i + 1;
                for (int k = i; k >= 0; k--) {
                    if (mtx[k][j] == 0){
                        heights[j] = i - k;
                        break;
                    }
                }
            }
            are = Math.max(are, largestRectangleArea(heights));
        }
        return are;
    }

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
