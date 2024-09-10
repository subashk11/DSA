package com.binarytree;

public class MaxPathSum {
    //find the maximum path sum

    static int maxSum = Integer.MIN_VALUE;
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(1);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.left.left.left = new Node(7);

        int maxPathSum = maxPathSum(root);
        System.out.println("Max Path Sum of the tree is "+ maxSum);
    }

    public static int maxPathSum(Node node){
        if(node == null) return 0;

        // 0 to avoid negative values
        int leftHeight = Math.max(0, maxPathSum(node.left));
        int rightHeight = Math.max(0, maxPathSum(node.right));

        maxSum = Math.max(maxSum, leftHeight+rightHeight+node.data);
        return Math.max(leftHeight, rightHeight)+node.data;
    }
}
