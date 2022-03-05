package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/1/21 16:11
 */
public class Offer013NumMatrix {
    public static void main(String[] args) {
        Offer013NumMatrix offer013NumMatrix = new Offer013NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(offer013NumMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(offer013NumMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(offer013NumMatrix.sumRegion(1, 2, 2, 4));
    }

    private int[][] sums;

    public Offer013NumMatrix(int[][] matrix) {
        int[][] sums = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < sums[0].length; j++) {
                sums[i][j] = matrix[i][j-1] + sums[i][j-1];
            }
        }
        this.sums = sums;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2+1] - sums[i][col1];
        }
        return sum;
    }
}
