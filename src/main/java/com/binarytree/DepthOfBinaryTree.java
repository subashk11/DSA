package com.binarytree;

public class DepthOfBinaryTree {
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

        System.out.println("Depth of the tree is "+ maxDepth(root));
    }

    private static int maxDepth(Node root) {
        if(root == null){
            return 0;
        }

        // find the left height and right height of the tree
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        //return the max of both heights
        return 1+Math.max(leftHeight,rightHeight);
    }
}
