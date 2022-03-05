package com.zdd.leetcode.offer;

import java.util.Stack;

/**
 * @description:
 * @author: zdd
 * @time: 2022/2/18 15:52
 */
public class Offer036EvalRPN {
    public static void main(String[] args) {
        Offer036EvalRPN offer036EvalRPN = new Offer036EvalRPN();
        System.out.println(offer036EvalRPN.evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer c = stack.pop();
                    Integer d = stack.pop();
                    stack.push(d/c);
                    break;
                default:
                    stack.push(new Integer(token));
            }
        }
        return stack.pop();
    }
}
