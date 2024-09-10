package com.linkedlist.singlylinkedlist;

import java.util.HashMap;
import java.util.Map;

//find the length of the loop in the linked list
public class LengthOfLoop {
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
        int lengthOfLoop = lengthOfLoop(list.head);
        System.out.println("Length of the loop: " + lengthOfLoop);
        int length = lengthOfLoopOptimized(list.head);
        System.out.println("Length of the loop: " + length);
    }

    private static int lengthOfLoop(LinkedListBasic.Node head) {
        //Map is used to store the node and their index
        Map<LinkedListBasic.Node, Integer> map = new HashMap<>();
        if(head == null || head.next == null){
            return 0;
        }
        LinkedListBasic.Node temp = head;
        int index = 0;
        while(temp != null){
            index++;
            if(map.containsKey(temp)){
                return index - map.get(temp);
            }
            map.put(temp, index);
            temp = temp.next;
        }
        return 0;
    }

    //optimized solution using Floyd's cycle detection algorithm
    public static int lengthOfLoopOptimized(LinkedListBasic.Node head) {
        if(head == null || head.next == null){
            return 0;
        }

        LinkedListBasic.Node slow = head;
        LinkedListBasic.Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int cnt =1;
                slow = slow.next;
                while(fast != slow){
                    slow = slow.next;
                    cnt++;
                }
                return cnt;
            }
        }

        return 0;
    }
}
