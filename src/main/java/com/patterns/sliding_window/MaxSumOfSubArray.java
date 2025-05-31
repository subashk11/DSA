package com.patterns.sliding_window;


// EXAMPLE FOR FIXED WINDOW SIZE PROBLEMS
public class MaxSumOfSubArray {

    // PROBLEM STATEMENT
    // Given an array of integers, find the maximum sum of a contiguous subarray of size k.

    // EXAMPLE
    // Input: arr = [2, 1, 5, 1, 3, 2], k = 3

    // Output: 9

    // Algorithm
    //1. sliding window technique

    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 5, 1, 3, 2};
        int k = 3;

        // Sum of all Sub arrays in the window
        sumOfSubArray(arr, k);

        // Max sum of all subarrays in the array
        maxSumOfSubArray(arr, k);

        // Min sum subarray of all subarrays in the array
        minSumOfSubArray(arr, k);
    }

    // Calculate all the sum for a particular window
    public static void sumOfSubArray(int[] arr, int k) {
        int n = arr.length;

        // base case -> window size should be less than array size
        if(n == 0 || n < k) {
            System.out.println("INVALID INPUT DETAILS");
            return ;
        }

        // Calculate sum for first window
        int windowSum = 0;
        for(int i = 0; i<k; i++) {
            windowSum += arr[i];
        }

        System.out.println("FIRST WINDOW SUM : "+ windowSum);

        // slide window to right
        for(int i = k; i<n; i++){
            windowSum += arr[i]-arr[i-k];
            System.out.println("WINDOW SUM AT : "+ i + " IS : "+ windowSum);
        }
    }

    // Max Sum of All subarrays in the array
    public static void maxSumOfSubArray(int[] arr, int k) {
        int n = arr.length;

        // null check and base conditions
        if(n == 0 || k > n) {
            System.out.println("INVALID INPUT DETAILS");
            return ;
        }

        // Variable to store max
        int maxSum = Integer.MIN_VALUE;

        // Variable to store window sum
        int windowSum = 0;
        for(int i = 0; i<k; i++) {
            windowSum += arr[i];
        }

        maxSum = Math.max(windowSum, maxSum);

        // Window sum
        for(int i=k; i<n; i++) {
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("\nMAX SUM OF SUBARRAY IN THE ARRAY IS : "+ maxSum);

    }

    // Min Sum of all sub arrays in the array
    public static void minSumOfSubArray(int[] arr, int k) {

        // variables
        int n = arr.length;
        int minSum = Integer.MAX_VALUE;
        int windowSum = 0;

        // conditions to check
        if(n == 0 || n < k) {
            System.out.println("INVALID INPUT DETAILS : ");
            return ;
        }

        // calculate first window
        for(int i = 0; i<k ;i++) {
            windowSum += arr[i];
        }

        minSum = Math.min(minSum, windowSum);

        // slide window to right
        for(int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i-k];
            minSum = Math.min(windowSum, minSum);
        }

        System.out.println("\nMIN SUM OF SUBARRAY IN THE ARRAY IS : "+ minSum);
    }
}


