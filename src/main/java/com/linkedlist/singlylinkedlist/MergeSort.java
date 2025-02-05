package com.linkedlist.singlylinkedlist;

import java.util.ArrayList;
import java.util.Random;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}
public class MergeSort {

    public static void main(String[] args) {
        // CLASS TO CREATE A NODE
        Node<Integer> head = new Node<>(10);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);

        Node<Integer> temp = head;

        Random random = new Random();

        for(int i = 0; i<12; i++){
            int randomNum = random.nextInt(50);
            temp.next = new Node<>(randomNum);
            temp = temp.next;
            arr.add(randomNum);
        }
        System.out.println("ADDED ITEMS : "+ arr.toString());
        Node<Integer> sortedHead = mergeSort(head);

        while(sortedHead != null){
            System.out.println("ITEM IN LINKED LIST IS : "+ sortedHead.data);
            sortedHead = sortedHead.next;
        }
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        //Your code goes here

        // BASE CASE
        if(head == null || head.next == null) {
            return head;
        }

        // FIND THE MIDDLE
        Node<Integer> middle = splitLL(head);

        Node<Integer> left = head;
        Node<Integer> right = middle.next;
        middle.next = null;

        // RECURSIVE CALL TO DIVIDE
        left = mergeSort(left);
        right = mergeSort(right);

        // MERGE
        return merge(left, right);

    }

    // MERGE FUNCTION
    public static Node<Integer> merge(Node<Integer> left, Node<Integer> right){
        Node<Integer> result = new Node<>(-1);
        Node<Integer> sortedLL = result;

        Node<Integer> p1 = left;
        Node<Integer> p2 = right;

        while(p1 != null && p2 != null){
            if(p1.data <= p2.data){
                result.next = p1;
                p1 = p1.next;
            } else {
                result.next = p2;
                p2 = p2.next;
            }
            result = result.next;
        }

        while(p1 != null){
            result.next = p1;
            p1 = p1.next;
            result = result.next;
        }

        while(p2 != null){
            result.next = p2;
            p2 = p2.next;
            result = result.next;
        }

        return sortedLL.next;
    }

    // FIND MIDDLE FUNCTION
    public static Node<Integer> splitLL(Node<Integer> head){
        // HARE AND TORTOISE ALGO

        if(head == null || head.next == null) return head;
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
