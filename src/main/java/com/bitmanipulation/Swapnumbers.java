package com.bitmanipulation;

public class Swapnumbers {
    public static void main(String[] args) {
        //swap two numbers without using third variable
        int a = 10;
        int b = 20;
        System.out.println("Before swapping a: " + a + " b: " + b);

        //use XOR operator
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("After swapping a: " + a + " b: " + b);
    }
}
