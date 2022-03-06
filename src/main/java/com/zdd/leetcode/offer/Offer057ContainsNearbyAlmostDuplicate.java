package com.zdd.leetcode.offer;

import java.util.TreeSet;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/5 10:57
 */
public class Offer057ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        Offer057ContainsNearbyAlmostDuplicate offer057ContainsNearbyAlmostDuplicate = new Offer057ContainsNearbyAlmostDuplicate();
        System.out.println(offer057ContainsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(new int[]{2147483646, 2147483647}, 3, 3));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
