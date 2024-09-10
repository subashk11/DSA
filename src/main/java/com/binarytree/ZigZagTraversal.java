package com.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    class Node{
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
        ZigZagTraversal tree = new ZigZagTraversal();
        Node root = tree.createTree();
        List<List<Integer>> result = tree.zigZagTraversal(root);
        System.out.println("ZigZag Traversal : " + result);
    }

    private List<List<Integer>> zigZagTraversal(Node root) {
        // Same as level order traversal
        // But we need to reverse the list for every alternate level
        boolean isLeftToRight = true;
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i =0;i<level;i++){
                Node currNode = queue.poll();
                int index = (isLeftToRight) ? i : queue.size() - i - 1;
                levelList.add(index, currNode.data);
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            result.add(levelList);
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }

    private Node createTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        return root;
    }
}
