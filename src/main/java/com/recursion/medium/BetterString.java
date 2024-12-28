package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class BetterString {

    // When two strings are provided of equal length
    // return strings which has most number of unique subsequences, if equal return first

    public static void main(String[] args) {
        String str1 = "gfg";
        String str2 = "ggg";

        // Use the rule take and not take of power set

        // two recursive calls to get the count of each items
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        int n1 = str1.length();
        int n2 = str2.length();

        recursiveFunctionCall(str1, "", n1, 0, list1);
        recursiveFunctionCall(str2, "", n2, 0, list2);

        int count1 = list1.size();
        int count2 = list2.size();

        System.out.println(" sizes of each substring of " + str1 + ": " + count1+ " and str2 :  " + count2);
    }

    private static void recursiveFunctionCall(String str, String subStr, int n, int idx, List<String> list) {

        // Base condition -> use idx for traversal if i == n return
        if(idx == n){
            String sub = subStr;
            // condition add to list only if it is not exist
            if(!list.contains(sub) && sub.length()>0){
                System.out.println("Substring formed : "+ sub);
                list.add(sub);
            }
            return;
        }

        // take
        recursiveFunctionCall(str, subStr+str.charAt(idx), n, idx+1, list);

        // not take
        if(subStr.length() > 0){
            subStr.substring(0, (subStr.length() -1));
        }

        recursiveFunctionCall(str, subStr, n, idx+1, list);
    }
}
