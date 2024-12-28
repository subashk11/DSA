package com.recursion.medium;

//get the fibonacci number at the provided index values
public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 10;
        int result = fibonacci(n);
        System.out.println(result);
    }

    private static int fibonacci(int n) {
        //base condition return n for 0 and 1. as it is the base sum for building the fibonacci.
        if(n <= 1) return n;
        int first = fibonacci(n-1);
        int second = fibonacci(n-2);
        return first + second;
    }
}
