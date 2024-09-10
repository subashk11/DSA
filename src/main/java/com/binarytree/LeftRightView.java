package com.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftRightView {

    // Recursive function to print left view of a binary tree.
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        LeftRightView tree = new LeftRightView();
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        List<Integer> leftList = new ArrayList<>();
        leftView(root, leftList, 0);
        List<Integer> rightList = new ArrayList<>();
        rightView(root, rightList, 0);
        System.out.println("Left View: " + leftList);
        System.out.println("Right View: " + rightList);
    }

    private static void rightView(Node root, List<Integer> list, int level) {
        if(root == null) return ;
        if(list.size() == level) list.add(root.data);

        //right traverse first for right view
        rightView(root.right, list, level+1);
        rightView(root.left, list, level+1);
    }

    private static void leftView(Node root, List<Integer> list, int level) {
        if(root == null) return ;
        if(list.size() == level) list.add(root.data);

        //left traverse first for left view
        leftView(root.left, list, level+1);
        leftView(root.right, list, level+1);

    }
}
