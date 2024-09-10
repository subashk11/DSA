package com.linkedlist.singlylinkedlist;

//find the middle node of the linked list
public class MiddleNode {
    public static int middleNode(LinkedListBasic.Node head){
        if(head == null || head.next == null){
            return head.data;
        }

        // slow and fast pointer approach
        LinkedListBasic.Node slow = head;
        LinkedListBasic.Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
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

        int middleNode = middleNode(list.head);
        System.out.println("\nMiddle Node: " + middleNode);
    }
}
