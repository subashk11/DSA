package com.linkedlist.singlylinkedlist;

public class GetStartingPointOfCycle {
    public static void main(String[] args) {
        //linked list with a loop
        LinkedListBasic list = new LinkedListBasic();
        list.insert(10);
        list.insert(20);
        list.insert(13);
        list.insert(37);
        list.insert(43);
        list.insert(7);

        //create a loop
        list.head.next.next.next.next.next.next = list.head.next.next;
        LinkedListBasic.Node resultNode= getStartingPointOfCycle(list.head);
        if(resultNode != null){
            System.out.println("Starting point of the loop: " + resultNode.data);
        }
    }

    //This is an upgraded implementation of slow and fast pointer algorithm
    // floyd cycle detection algorithm

    // Detect the loop
    // after detecting the loop, move the fast pointer to the head.
    // move the slow pointer and fast pointer one step at a time until they meet.
    private static LinkedListBasic.Node getStartingPointOfCycle(LinkedListBasic.Node head) {
        if(head == null || head.next == null || head.next == head){
            return head;
        }
        LinkedListBasic.Node slow = head;
        LinkedListBasic.Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
