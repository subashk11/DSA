package com.recursion;

public class ConsecutiveOnes {
    // Problem states that for n input  return the count of bits where there should not exists any
    // consecutive ones

    // For n =2 : o/p = 3 , 00,01,10 as 11 is excluded as per problem statement

    public static void main(String[] args) {
        int n = (int) (Math.random() * 10) + 1;

        // Return if n ==1
        int countZero = 1;
        int countOne = 1;

        System.out.println(" For n = "+n);

        int resultSum = countOne + countZero;
        if(n == 1){
            System.out.println(resultSum);
        } else {
           resultSum = countSum(2, n, countOne, countZero, resultSum);
            System.out.println(" Value of recursive function : " + resultSum);
        }
    }

    private static int countSum(int i, int n, int prevCountOne, int prevCountZero, int prevSum) {
        if(n < i) return prevSum;

        // set prev number zeroCount to countOne for current Number
        prevCountOne = prevCountZero;

        // Set count of previous number for Zero
        prevCountZero = prevSum;

        prevSum = prevCountOne+prevCountZero;

        i = i+1;

        return countSum(i, n, prevCountOne, prevCountZero, prevSum);  // Recursive call
    }

}
