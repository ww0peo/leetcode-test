package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/10 16:35
 */
public class Offer069PeakIndexInMountainArray {

    public static void main(String[] args) {
        Offer069PeakIndexInMountainArray offer069PeakIndexInMountainArray = new Offer069PeakIndexInMountainArray();
        System.out.println(offer069PeakIndexInMountainArray.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        return  search(arr, 0, arr.length - 1);
    }

    public int search(int[] arr, int left, int right){
        int middle = (left + right)/2;
        if (arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]){
            return middle;
        }
        if (arr[middle - 1] > arr[middle]){
            return search(arr, left, middle);
        }else {
            return search(arr, middle, right);
        }
    }
}
