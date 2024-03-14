package com.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SingleTraversal {

    // create a tree and insert dummy data
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

    class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(1);
        root.left.left = new Node(4);
        root.right.left = new Node(6);

        // print all the three traversals using a single traversal
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        //create a stack of pair of Node and number to store the node is in which traversal
        //1. preorder 2. inorder 3. postorder
        Stack<Pair> stack = new Stack<>();

        //check if the root is not null and add it to the stack
        if(root != null){
            stack.push(new SingleTraversal().new Pair(root, 1));
        }

        //traverse until the stack is empty
        while(!stack.isEmpty()){

            //take the top item in the stack
            Pair top = stack.pop();
            if(top.state == 1){
                preOrder.add(top.node.data);
                top.state++;
                stack.push(top);
                // add the left node to the stack
                if(top.node.left != null){
                    stack.push(new SingleTraversal().new Pair(top.node.left, 1));
                }
            }else if(top.state == 2){
                //Inorder traversal
                inOrder.add(top.node.data);
                top.state++;
                stack.push(top);
                if(top.node.right != null){
                    stack.push(new SingleTraversal().new Pair(top.node.right, 1));
                }
            }else{
                //postorder traversal
                postOrder.add(top.node.data);
            }
        }

        System.out.println("PreOrder Traversal" + preOrder);
        System.out.println("InOrder Traversal" + inOrder);
        System.out.println("PostOrder Traversal" + postOrder);
    }
}
