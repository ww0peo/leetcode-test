package com.zdd.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/18 14:44
 */
public class Offer035FindMinDifference {

    public static void main(String[] args) {
        Offer035FindMinDifference offer035FindMinDifference = new Offer035FindMinDifference();
        System.out.println(offer035FindMinDifference.findMinDifference(new ArrayList<String>() {{
            add("12:12");
            add("00:13");
        }}));
    }

    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] timeArr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            timeArr[i] = calculateMinByZero(timePoints.get(i));
        }
        Arrays.sort(timeArr);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < timeArr.length - 1; i++) {
            minDifference = Math.min(minDifference, timeArr[i + 1] - timeArr[i]);
        }
        minDifference = Math.min(minDifference, 1440 - timeArr[timeArr.length - 1] + timeArr[0]);
        return minDifference;
    }

    public int calculateMinByZero(String time){
        String[] times = time.split(":");
        int h = new Integer(times[0]);
        int m = new Integer(times[1]);
        int min = h * 60 + m;
        return min;
    }
}
