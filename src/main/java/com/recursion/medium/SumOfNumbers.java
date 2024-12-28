package com.recursion.medium;

import java.util.*;

//this is to return a sum of numbers from 1 to n.
public class SumOfNumbers {
    public static void main(String[] args) {
        int n = 5;
        int result = sumOfNumbers(n);
        System.out.println("The sum of numbers is "+result);
    }

    private static int sumOfNumbers(int n) {
        //break condition if n is 0 return 0;
        if(n == 0) return 0;
        return n + sumOfNumbers(n-1); // recursive call from n to n-1 and so on until n =0.
    }
}
