package com.linkedlist.singlylinkedlist;


public class Palindrome {
    public static void main(String[] args) {
        LinkedListBasic list = new LinkedListBasic();
        list.insert(10);
        list.insert(20);
        list.insert(13);
        list.insert(37);
        list.insert(43);
//        list.insert(7);
        list.insert(43);
        list.insert(37);
        list.insert(13);
        list.insert(20);
        list.insert(10);
        list.printList();

        System.out.println("\nIs Palindrome: " + isPalindrome(list.head));
    }

    private static boolean isPalindrome(LinkedListBasic.Node head) {
        if(head == null || head.next == null){
            return true;
        }

        LinkedListBasic.Node slow = head;
        LinkedListBasic.Node fast = head;

       while(fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }

        System.out.println("\nMiddle Node: " + slow.data);
       LinkedListBasic.Node secondHead =  reverseSecondList(slow.next);
       LinkedListBasic.Node firstHalf = head;
       LinkedListBasic.Node secondHalf = secondHead;

       while(secondHalf != null){
           if(firstHalf.data != secondHalf.data){
               return false;
           }
           firstHalf = firstHalf.next;
           secondHalf = secondHalf.next;
        }
        return true;
    }

    private static LinkedListBasic.Node reverseSecondList(LinkedListBasic.Node head) {
        if(head == null || head.next == null){
            return head;
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

        return prev;
    }

}
