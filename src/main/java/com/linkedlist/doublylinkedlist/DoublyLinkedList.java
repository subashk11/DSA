package com.linkedlist.doublylinkedlist;

public class DoublyLinkedList {
    Node head;

    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    //Insert a node to a dll
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    //print all the items in a dll
    public void printList(){
        if(head == null) return ;
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
    }

    //delete a node
    public void deleteNode(int data){
        if(head == null) return ;
        Node temp = head;
        while(temp.next != null){
            if(temp.data == data){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
    }

    //reverse a dll
    public void reverseList(){
        if(head == null) return ;
        Node temp = head;
        Node prev = null;
        while(temp != null){
//            prev = temp.prev;
//            temp.prev = temp.next;
//            temp.next = prev;
//            temp = temp.prev;
            Node next = temp.next;
            temp.next = prev;
            temp.prev = next;
            prev = temp;
            temp = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList llist = new DoublyLinkedList();
        llist.head = new Node(1);
        llist.insert(4);
        llist.insert(11);
        llist.insert(14);
        llist.insert(6);

        llist.printList();
        System.out.println("\nList after removing the item : 14 :  ");
        llist.deleteNode(14);
        llist.insert(23);
        llist.printList();
        llist.reverseList();
        System.out.println("\nList after reversing");
        llist.printList();
    }
}
