package com.recursion.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DailPadProblem {

    // Problem Definition

    // Return possible strings that can be formed from the input passed

    // ie: 56 ->
    // 5 -> jkl
    // 6 -> mno

    // output :
    // jm, jn, jo, km, kn, ko, lm, ln, lo -> 9 count

    // for 0 or 1 return empty string if present.

    public static void main(String[] args) {
        // store the map for each possible numbers
        Map<Integer, Character[]> numPad = new HashMap<>();

        numPad.put(2, new Character[]{'a', 'b', 'c'});
        numPad.put(3, new Character[]{'d', 'e', 'f'});
        numPad.put(4, new Character[]{'g', 'h', 'i'});
        numPad.put(5, new Character[]{'j', 'k', 'l'});
        numPad.put(6, new Character[]{'m', 'n', 'o'});
        numPad.put(7, new Character[]{'p', 'q', 'r', 's'});
        numPad.put(8, new Character[]{'t', 'u', 'v'});
        numPad.put(9, new Character[]{'w', 'x', 'y', 'z'});

        // Input
        int input = 26;

        // Output
        ArrayList<String> combinationStrList = new ArrayList<>();

        // recursive function call.
        generatePossibleStrings(numPad, input, combinationStrList, "");

        System.out.println("Possible Strings are : "+ combinationStrList.toString());
    }

    // recursive function
    public static void generatePossibleStrings(Map<Integer, Character[]> numPad, int number, ArrayList<String> combinationStrList, String combinationString){
        // Base case if number is 0 or 1 return null;
        if((number == 0 || number == 1)) {
            if(number == 0) {
                combinationStrList.add(combinationString);
                return;
            }
        }

        // get the last number
        int digit = number;

        digit = number%10;
        Character[] charList = numPad.get(digit);

        for(Character ch : charList) {
            generatePossibleStrings(numPad, number/10, combinationStrList, ch+combinationString);
        }



    }
}
