package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/17 17:19
 */
public class Offer034IsAlienSorted {

    public static void main(String[] args) {
        Offer034IsAlienSorted offer034IsAlienSorted = new Offer034IsAlienSorted();
        System.out.println(offer034IsAlienSorted.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            byte[] bytes1 = words[i].getBytes();
            byte[] bytes2 = words[i + 1].getBytes();
            int len = Math.min(bytes1.length, bytes2.length);
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                byte b1 = bytes1[j];
                byte b2 = bytes2[j];
                if (order.indexOf(b1) > order.indexOf(b2)){
                    return false;
                }else if (order.indexOf(b1) < order.indexOf(b2)){
                    flag = true;
                    break;
                }
            }
            if (bytes1.length > bytes2.length && !flag){
                return false;
            }else {
                flag = false;
            }
        }
        return true;
    }

}
