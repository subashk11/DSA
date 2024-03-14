package com.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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

        System.out.println("Level Order Traversal");
        List<List<Integer>> result  = levelOrder(root);
        for(List<Integer> temp : result){
            System.out.println(temp);
        }
    }


    public static List<List<Integer>> levelOrder(Node node){

        // create a queue to store the current level items
        Queue<Node> queue = new LinkedList<>();

        // list of list data structure to store the list of items at each level.
        List<List<Integer>> list = new ArrayList<>();

        //add the root node to the queue if it is not null
        if(node == null) return null;
        queue.offer(node);

        //iterate until the  queue is empty ie no more items in the tree to add.
        while(!queue.isEmpty()){
            // find the level currently by getting the size of the queue.
            int level = queue.size();
            //create a list to store the current level items
            List<Integer> levelList = new ArrayList<>();

            //traverse through the nodes in the queue and add the respective left and right of it
            for(int i =0;i<level;i++){
                Node currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
                levelList.add(currentNode.data);
            }

            //add the levelList to the result list
            list.add(levelList);
        }

        return list;
    }



}
