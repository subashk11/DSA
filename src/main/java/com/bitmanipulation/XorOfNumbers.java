package com.bitmanipulation;

public class XorOfNumbers {

    //XOR of numbers from 1 to N
    public static void main(String[] args) {
        int n = 5;
        int result = xorOfNumbers(n);
        System.out.println("XOR of numbers from 1 to " + n + " : " + result);
    }

    private static int xorOfNumbers(int n) {
        // rule for every four number in the sequence from 1 to n the result will be the same
        // 1 n+1 0 4 for every four numbers
        if(n % 4 == 1) {
            return 1;
        }  else if (n % 4 == 2) {
            return n + 1;
        } else if(n % 4 == 3) {
            return 3;
        } else {
            return 4;
        }
    }
}
