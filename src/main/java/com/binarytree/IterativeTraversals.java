package com.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversals {

    //Key constraint is that we should not use recursion
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
        List<Integer> list = preOrder(root);
        System.out.println("This is the result of preOrder traversal "+ list);
        System.out.println("\nPostOrder Traversal");
        List<Integer> list1 =postOrder(root);
        System.out.println("This is the result of postOrder traversal "+ list1);
        System.out.println("\nInOrder Traversal");
        List<Integer> list2 =inOrder(root);
        System.out.println("This is the result of inOrder traversal "+ list2);
    }

    public static List<Integer> preOrder(Node node){

        // use stack for depth first traversals
        Stack<Node> stack = new Stack<>();

        // list to store the items in the traversals
        List<Integer> result = new ArrayList<>();

        //check if the node is not null add it to the stack
        if(node == null) return null;
        stack.push(node);

        // traverse through the tree until there is no items in the stack to add
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            result.add(currNode.data);
            //add the right item first and left as the stack follows last in first out so the left node will be on top
            if(currNode.right != null){
                stack.push(currNode.right);
            }
            if(currNode.left != null){
                stack.push(currNode.left);
            }
        }

        return result;
    }

    //Iterative postOrder
    public static List<Integer> postOrder(Node node){

        //create a stack to maintain the items in the tree
        Stack<Node> stack = new Stack<>();

        //list to store the values of traversals
        List<Integer> result = new ArrayList<>();

        //stack2 to store the order of traversal
        Stack<Node> stack2 = new Stack<>();

        //check if the node is not null
        if(node == null) return null;

        //add the root node to the stack first to start traversal
        stack.push(node);

        //start traversal until there are no nodes in the stack
        while(!stack.isEmpty()){
            //get the node
            Node currNode = stack.pop();

            //add the currentNode to the stack2
            stack2.push(currNode);
            if(currNode.left != null){
                stack.push(currNode.left);
            }
            if(currNode.right != null){
                stack.push(currNode.right);
            }

        }

        while(!stack2.isEmpty()){
            result.add(stack2.pop().data);
        }
        return result;
    }

    //Inorder traversal
    public static List<Integer> inOrder(Node node){

        // create a stack to maintain the nodes
        Stack<Node> stack = new Stack<>();

        //list to store the values of the traversals
        List<Integer> result = new ArrayList<>();

        Node temp = node;

        //traverse through the entire left of the tree untill there is no item in the left
        //add those items to the stack while traversing
        // if the node is null pop the top item and add it to the list and move to right
        while(true){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                if(stack.isEmpty()) break;
                temp = stack.pop();
                result.add(temp.data);
                temp = temp.right;
            }
        }

        return result;
    }
}
