package com.linkedlist.singlylinkedlist;

public class OddEvenIndex {
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

        System.out.println("\nOdd Even Index: ");
        oddEvenIndex(list.head);
        list.printList();
    }

    private static void oddEvenIndex(LinkedListBasic.Node head) {
        if(head == null || head.next == null){
            return ;
        }
        
        LinkedListBasic.Node odd = head;
        LinkedListBasic.Node even = head.next;
        LinkedListBasic.Node evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }
}
