package com.binarytree;

public class BalancedBinaryTree {
    //create a tree and insert dummy data
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

        System.out.println("Is the tree balanced? "+ isBalanced(root));
        System.out.println("Optimized approach:");
        int height = isBalancedOptimized(root);
        if(height == -1) {
            System.out.println("The tree is not balanced " + height);
        }else{
            System.out.println("The tree is balanced " + height);
        }

    }

    //Bruteforce approach
    //1. Find the left and right height from the current node.
    //2. If the difference between the left and right height is greater than 1, return false.
    //3. Else, move to next node and repeat the process.
    private static boolean isBalanced(Node root) {
        if(root == null) return  true;

        //find the left and right height of the tree
        int leftHeight = maxDepthLeft(root.left);
        int rightHeight = maxDepthRight(root.right);

        if(Math.abs(leftHeight-rightHeight) > 1){
            return false;
        }

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);

        if(!leftBalanced || !rightBalanced){
            return false;
        }

        return true;
    }

    public static int maxDepthLeft(Node node){
        if(node == null){
            return 0;
        }

        return 1+maxDepthLeft(node.left);
    }

    public static int maxDepthRight(Node node){
        if(node == null){
            return 0;
        }

        return 1+maxDepthRight(node.right);
    }

    //Optimized approach , find the height of the binary tree/depth of the binary tree
    public static int isBalancedOptimized(Node root){
        if(root == null) return 0;

        int leftHeight = isBalancedOptimized(root.left);
        int rightHeight = isBalancedOptimized(root.right);
        // If any one of the height is -1 then return -1;
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        // if the difference is more than 1 return -1;
        if(Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }

        return 1+Math.max(leftHeight,rightHeight);
    }
}
