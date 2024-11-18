package com.new_problems.sorting.iterative;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class InsertionSort {

    // Insertion Sort
    // Intution
    // check the left window and move the current item i to its correct position
    // lowest first
    // check the left window as left is sorted // assumption and move the i-th item to its correct position

    public static void main(String[] args) {
        int[] arr={5,3,7,4,2,1};

        int n =arr.length;
        // loop to check the left window
        for(int i = 0;i<n;i++){
            // inner loop to move the ith index to right position
            int idx = i;
            while(idx>0){
                // check items in left index;
                if(arr[idx] < arr[idx-1]){
                    int temp = arr[idx];
                    arr[idx] = arr[idx-1];
                    arr[idx-1] = temp;
                }
                idx--;
            }
        }

        System.out.println(" OUTPUT SORTED ARRAY : "+ Arrays.toString(arr));
    }

    // TIME COMPLEXITY - O(N^2)
}
