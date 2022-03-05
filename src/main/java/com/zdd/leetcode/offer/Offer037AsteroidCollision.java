package com.zdd.leetcode.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/18 16:09
 */
public class Offer037AsteroidCollision {
    public static void main(String[] args) {
        Offer037AsteroidCollision offer037AsteroidCollision = new Offer037AsteroidCollision();
        System.out.println(offer037AsteroidCollision.asteroidCollision(new int[]{-2, -1, 2, 1}));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0){
                stack.push(asteroid);
            }else {
                while (true){
                    if (stack.empty()) {
                        stack.push(asteroid);
                        break;
                    }
                    Integer pop = stack.pop();
                    if (pop < 0){
                        stack.push(pop);
                        stack.push(asteroid);
                        break;
                    }else {
                        if (-asteroid < pop){
                            stack.push(pop);
                            break;
                        }else if (-asteroid == pop){
                            break;
                        }
                    }
                }
            }
        }
        int[] ret = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
