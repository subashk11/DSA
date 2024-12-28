package com.recursion.medium;
import java.lang.*;

//check the string is a palindrome or not using recursion.
public class PalindromeString {

    public static void main(String[] args) {
        String text = "madam";
        boolean isPalindrome = checkPalindrome(0, text);
        System.out.println(isPalindrome);
    }

    private static boolean checkPalindrome(int i, String text) {
        if(i >= text.length()/2)return true; //The index should not pass the middle as it is same after middle
        //in palindrome.

        if(text.charAt(i) != text.charAt(text.length()-i-1))return false; // if left and right are not equal return false;

        return checkPalindrome(i+1, text);
    }
}
