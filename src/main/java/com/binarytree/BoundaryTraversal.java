package com.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BoundaryTraversal {
    //create a class to represent the node in the tree
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
        //create a tree of height 4 and insert dummy data
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        System.out.println("Boundary Traversal");
        List<Integer> result = boundaryTraversal(root);
        System.out.println(result);
    }

    private static List<Integer> boundaryTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        // Do a left traversal and store the left nodes in a list not a leaf node
        leftTraversal(root, result);
        // Do a leaf traversal and store the leaf nodes in a list
        leafTraversal(root, result);
        // Do a right traversal and store the right nodes in a list not a leaf node
        rightTraversal(root, result);
        return result;
    }

    private static void rightTraversal(Node root, List<Integer> result) {
        Node curr = root;
        while(curr != null){
            if(isLeafNode(curr)) result.add(curr.data);
            if(curr.right != null) {
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
    }

    private static void leafTraversal(Node root, List<Integer> result) {
        if(root == null) return;
        if(isLeafNode(root)) result.add(root.data);
        leafTraversal(root.left, result);
        leafTraversal(root.right, result);
    }

    private static void leftTraversal(Node root, List<Integer> result) {
        Node curr = root;
        while(curr != null){
            if(isLeafNode(curr)) result.add(curr.data);
            if(curr.left != null) {
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }

    private static boolean isLeafNode(Node curr) {
        if(curr.left == null && curr.right == null) return true;
        return false;
    }
}
