package com.linkedlist.singlylinkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedListBasic list = new LinkedListBasic();
        list.insert(10);
        list.insert(20);
        list.insert(13);
        list.insert(37);
        list.insert(43);
        list.insert(7);
        list.insert(23);
        list.printList();

        reverseList(list.head);
        System.out.println("\nReversed List: ");
        list.printList();
    }

    private static void reverseList(LinkedListBasic.Node head) {
        if(head == null || head.next == null){
            return ;
        }

        LinkedListBasic.Node curr = head;
        LinkedListBasic.Node prev = null;

        //prev is used as a temporary node to store the previous node
        while(curr != null){
            LinkedListBasic.Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        LinkedListBasic.head = prev;

    }
}
