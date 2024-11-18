package com.problems;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        // array
        int[] arr = {6, 1, 6, 5, 3, 2, 5, 0, 5, 6, 0};
        int num = 5;

        //Your code goes here

        // brute force
        // n3 time complexity

        int count = 0;

        int n = arr.length;

        // optimal approach
        // since array is sorted we can apply two pointer/binary search

        Arrays.sort(arr);

        System.out.println("array is : "+ Arrays.toString(arr));

        // loop to target the first pointer i
        for(int i = 0;i<n;i++){
            // apply two pointer
            if(i>0 && arr[i-1] == arr[i]) continue;

            int l = i+1;
            int h = n-1;
            while(l<h){
                // get the sum
                int sum = arr[i]+arr[l]+arr[h];

                // check for lesser
                if(sum<num){
                    l++;
                }else if(sum > num){
                    h--;
                }else {
                    // sum == num
                    count++;
                    // move to next item
                    l++;
                    h--;

                    // logic to avoid duplicates
                    while(l<h && arr[l]==arr[l-1])l++;
                    while(l<h && arr[h]==arr[h+1])h--;
                }
            }
        }

        System.out.println(" COUNT RESULT IS : "+ count);
    }

}
