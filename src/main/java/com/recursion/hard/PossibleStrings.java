package com.recursion.hard;

import java.util.ArrayList;

public class PossibleStrings {

    // Generate Possible Strings formed based on number provided
    // a-1, b-2 .. z-26


        // Return a string array that contains all possible codes
    public static void main(String[] args){
        // Write your code here


        // Need to check each single integer,

        // Need to check a buffer of two digits and first digit should be be either 1 or 2,
        // Second digit should be from 0 to 6.

        int bufferSize = 1;


        // Unicode value of a is 97
        // Get the character by digit + 96 if digit is 1 so char = 1+96 = 97 = a

        ArrayList<String> result = new ArrayList<>();
        String input = "1123";

        generatePossibleStrings(input, 0, result, "");

        String[] res = new String[result.size()];

        for(int i = 0;i<result.size();i++){
            res[i] = result.get(i);
            System.out.println(" item at : "+ i + " is : "+ res[i]);
        }

    }

    public static void generatePossibleStrings(String number, int idx, ArrayList<String> result, String tracker) {
        // Base condition: if we've processed the entire input string
        if (idx == number.length()) {
            result.add(tracker);
            return;
        }

        // Take one digit
        char singleDigitChar = (char) (number.charAt(idx) - '0' + 96);
        generatePossibleStrings(number, idx + 1, result, tracker + singleDigitChar);

        // Take two digits (if possible)
        if (idx + 1 < number.length()) {
            int doubleDigit = Integer.parseInt(number.substring(idx, idx + 2));
            if (doubleDigit >= 1 && doubleDigit <= 26) {
                char doubleDigitChar = (char) (doubleDigit + 96);
                generatePossibleStrings(number, idx + 2, result, tracker + doubleDigitChar);
            }
        }
    }

}
