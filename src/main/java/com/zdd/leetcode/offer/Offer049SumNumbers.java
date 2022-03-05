package com.zdd.leetcode.offer;

/**
 * @description:
 * @author: zdd
 * @time: 2022/3/1 17:00
 */
public class Offer049SumNumbers {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        Offer049SumNumbers offer049SumNumbers = new Offer049SumNumbers();
        System.out.println(offer049SumNumbers.sumNumbers(treeNode1));
    }


    public int sumNumbers(TreeNode root) {
        int sum = 0;
        String num = root.val + "";
        sum = getNum(num, sum, root);
        return sum;
    }

    public int getNum(String num, int sum, TreeNode node){
        if (node.left != null){
            sum = getNum(num + node.left.val, sum, node.left);
        }
        if (node.right != null){
            sum = getNum(num + node.right.val, sum, node.right);
        }
        if (node.left == null && node.right == null){
            sum += Integer.parseInt(num);
        }
        return sum;
    }

}
