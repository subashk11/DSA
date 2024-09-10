package com.linkedlist.singlylinkedlist;

public class LinkedListBasic {
    //Node to store the head of the linked list
    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Insert a new node at the end of the linked list
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
        }
    }

    //Print the linked list
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    //insert a node at the beginning of the linked list
    public void insertAtStart(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Remove a given node from the linked list
    private void remove(int i) {
        Node temp = head;
        Node prev = null;
        if(temp == null) return ;
        while(temp.next != null){
            if(temp.data == i){
                System.out.println("\n Removing: " + i);
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Size or length of the linked list
    public int sizeOfList(Node node){
        if(node == null) return 0;
        int len = 0;
        Node temp = node;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    //find an item
    public boolean isPresent(int data){
        if(head == null) return false;
        Node temp = head;
        while(temp.next != null){
            if(temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedListBasic linkedList = new LinkedListBasic();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insertAtStart(0);
        linkedList.printList();

        //remove a node - 2
        linkedList.remove(2);
        System.out.println();
        linkedList.printList();

        //Size of the list
        int size = linkedList.sizeOfList(linkedList.head);
        System.out.println("\nThe size of linked list is "+ size);

        System.out.println("The data 3 is present or not in linked list : "+ linkedList.isPresent(3));
    }



}
