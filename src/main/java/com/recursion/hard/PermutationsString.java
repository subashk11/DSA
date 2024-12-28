package com.recursion.hard;

public class PermutationsString {

    /** String s = “abc”
        output = [”abc”, “acb”,”bac”,”bca”,”cab”,”cba”]
        Formula to calculate number of permutations: n!
        where n = length of string
        For string "abc", n = 3

        Therefore, number of permutations = 3! = 3 × 2 × 1 = 6

        For example, starting with 'a' in first position, we then permute 'bc' to get 'abc' and 'acb'.
        Similarly with 'b' first, we permute 'ac', and with 'c' first, we permute 'ab'. **/

    // Problem States return all the permutations of the string.
    public static void main(String[] args) {
        String str = "abc";

        StringBuilder s = new StringBuilder(str);

        recursiveFunctionCall(s, 0);
    }

    public static void recursiveFunctionCall(StringBuilder str, int idx) {
        // Base condition if idx == n
        if(idx == str.length()) {
           // Print the permutation
            System.out.println("Permutation : "+ str);
            return ;
        }

        // Start from idx -> as previous items are already done.
        // Apply permutation by moving items to current index by swapping until last item is swapped
        for(int i = idx; i<str.length(); i++){
            // Swap
            swap(str, i, idx);
            System.out.println("Swapping items "+str.charAt(i)+ " with : "+str.charAt(idx) + " for position at index : "+idx);

            // recursive call
            recursiveFunctionCall(str, idx+1);
            System.out.println();

            // backtrack to make the string to original state
            swap(str, i, idx);
        }

    }

    public static void swap(StringBuilder str, int left, int right) {
        char temp = str.charAt(left);
        str.setCharAt(left, str.charAt(right));
        str.setCharAt(right, temp);
    }
}
