package com.linkedlist.singlylinkedlist;

import java.util.List;

public class DetectLoop {
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
        System.out.println("Loop detected: " + detectLoop(list.head));
    }

    // tortoise and hare algorithm
    private static boolean detectLoop(LinkedListBasic.Node head) {
        if(head == null || head.next == null){
            return false;
        }

        LinkedListBasic.Node slow = head;
        LinkedListBasic.Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
