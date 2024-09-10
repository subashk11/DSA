package com.binarytree;

public class MaxWidthofTree {

    //create a Node class to store the data and the address of left and right child
    static int maxi =0;
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

        int maxWidth = maxWidth(root);

        System.out.println("Max Width of the tree is "+ ++maxi);
        maxi = 0;
        int maxWidthOptimized = maxWidthOptimized(root);
        System.out.println("Max Width of the tree Optimized approach "+ maxi);
    }

    //Bruteforce approach , getting the left height and right height of each node and finding the max width
    private static int maxWidth(Node root) {
        if(root == null) return 0;

        int leftHeight = leftHeight(root.left);
        int rightHeight = rightHeight(root.right);

        maxi = Math.max(maxi, leftHeight+rightHeight);
        maxWidth(root.left);
        maxWidth(root.right);

        return maxi;
    }

    public static int leftHeight(Node root){
        if(root == null) return 0;
        return 1+leftHeight(root.left);
    }

    public static int rightHeight(Node root){
        if(root == null) return 0;
        return 1+rightHeight(root.right);
    }

    //Optimized approach
    public static int maxWidthOptimized(Node root){
        if(root == null) return 0;

        int leftHeight = maxWidthOptimized(root.left);
        int rightHeight = maxWidthOptimized(root.right);

        maxi = Math.max(maxi, leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
