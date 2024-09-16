package com.new_problems.recursion;

public class towerOfHanoi {

    // Problem states that move all the disks from starting rod to the last rod with the help of helper rod.

    public static void main(String[] args) {
        // N states the number of disks in the rod A
        int n = 5;
        towerOfHanoi(n, "A", "B", "C");
    }

    public static void towerOfHanoi(int n, String from_rod, String to_rod, String helper_rod){

        // Base condition -> break if there is only one disk in the rod
        if(n == 1){
            System.out.println("Moving disk : 1 from rod : "+ from_rod + " : to rod : "+ to_rod);

            return ;
        }

        // Move all the rods to helper rod.
        towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Moving disk : "+ n + " from rod : "+ from_rod + " : to rod : "+ to_rod);

        // Move all the disks from helper to last_rod
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }
}
