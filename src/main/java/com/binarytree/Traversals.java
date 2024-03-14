package com.binarytree;

public class Traversals {
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

        System.out.println("PreOrder Traversal");
        preOrder(root);
        System.out.println("\nPostOrder Traversal");
        postOrder(root);
        System.out.println("\nInOrder Traversal");
        inOrder(root);
    }

    private static void preOrder(Node root) {
        if(root == null){
            return;
        }
        //root left right
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;
        //left right root
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void inOrder(Node root){
        if(root == null) return;
        //left root right
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}
