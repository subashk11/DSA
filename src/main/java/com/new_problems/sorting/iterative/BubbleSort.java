package com.new_problems.sorting.iterative;

import java.util.Arrays;

public class BubbleSort {

    // Bubble sort
    // Intution : Move the greatest to the last index
    // check the range from 0 to n-1
    // Get the greatest and move it to n-1
    // Now check the range from 0 to n-2
    // move the greatest to n-2 and so on until 0

    public static void main(String[] args) {
        // sample array
        int[] arr = {4,1,3,7,11,9};

        int n =arr.length;

        // outer loop to check the range
        for(int i =0;i<n;i++){ // N times
            // inner loop to get the largest item
            // and swap by checking adjacent item
            for(int j=i;j<n-i-1;j++){ // N-i times N
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // output
        System.out.println("SORTED ARRAY : "+ Arrays.toString(arr));
    }

    // TIME COMPLEXITY - O(N^2)
}
