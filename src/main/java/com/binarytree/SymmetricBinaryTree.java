package com.binarytree;

public class SymmetricBinaryTree {
    // Recursive function to check if a binary tree is symmetric.
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        SymmetricBinaryTree tree = new SymmetricBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(isSymmetric(root.left, root.right));
    }

    // create a helper function to check if the tree is symmetric
    public static boolean isSymmetric(Node root) {
        return  root == null || root.left == root.right;
    }

    public static boolean isSymmetric(Node left, Node right) {
        if(left == null || right == null) return left == right;
        if(left.data != right.data) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
