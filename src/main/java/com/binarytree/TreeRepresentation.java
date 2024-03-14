package com.binarytree;

//Every node in a tree has left and right to hold the child address
public class TreeRepresentation {

    Node root;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);

        System.out.println("Tree Representation");
    }
}
