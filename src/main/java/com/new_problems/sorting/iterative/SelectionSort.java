package com.new_problems.sorting.iterative;

import java.sql.Time;
import java.util.Arrays;

public class SelectionSort {
    // It is a sorting technique of Iterative Approach.

    // Intution
    // Check the lowest value in the array
    // lowest item should be in left side - as sorting in increasing order.
    // let i will be the pointer traverse through out the range of items
    // Inner loop will run from i to n to check the lowest value
    // swap the lowest value with i-th item and move to next position

    public static void main(String[] args) {
        // sample input
        int[] arr={1,2,3,4,5,11,7};

        int n = arr.length;

        // Range
        // i -> 0 to n-2
        // j -> 0 to n-1

        // loop for pointer
        int i = 0;
        while(i<n-1){ // run for N times
            // inner loop to check the lowest
            int j = i+1;
            int lowest = i;
            while(j<n){ // run for N-i times ie N
                if(arr[j]<arr[i] && arr[j]<arr[lowest]){
                    lowest = j;
                }
                j++;
            }

            // check and swap items
            if(lowest != i){
                int temp = arr[i];
                arr[i] = arr[lowest];
                arr[lowest] = temp;
            }

            // move to next pointer
            i++;
        }

        System.out.println("Sorted Array is : "+ Arrays.toString(arr));
    }

    // TIME COMPLEXITY : O(N^2)
}
