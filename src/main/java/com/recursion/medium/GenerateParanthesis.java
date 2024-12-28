package com.recursion.medium;



public class GenerateParanthesis {
    // Problem states that generate all possible valid paranthesis from the n;

    // if n = 2 , o/p = (()) ()() are two possible valid paranthesis set

    public static void main(String[] args) {
        // Rules :
        // Each paranthesis should start with open.
        // Add close when count of closed < count of open
        // Check the count of open and close should less than or equal to n;

        int n = (int)(Math.random() * 10)+1;

        int countOfOpen = 0;
        int countOfClose = 0;

        recursiveFunctionCall(3, countOfOpen, countOfClose, "");
    }

    private static void recursiveFunctionCall(int n, int countOfOpen, int countOfClose, String str) {

        // Print the string when countofOpen and countofclose == n;
        if(n == countOfOpen && n == countOfClose){
            System.out.println("Valid paranthesis : " +str);
            return ;
        }

        // If countOfClose < countOfOpen, add ')' to the string and increment countOfClose
        if (countOfClose < countOfOpen) {
            recursiveFunctionCall(n, countOfOpen, countOfClose + 1, str + ")");
        }

        // If countOfOpen < n, add '(' to the string and increment countOfOpen
        if (countOfOpen < n) {
            recursiveFunctionCall(n, countOfOpen + 1, countOfClose, str + "(");
        }


    }
}
