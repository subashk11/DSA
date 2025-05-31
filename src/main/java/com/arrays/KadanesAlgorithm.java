package com.arrays;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        // Kadane's Algorithm
        // Find the maximum sum of a subarray
        int[] arr = {5, 7, 2, 4, -9, 9, 6, -3, 8, 1};
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0;i<arr.length;i++){
            sum += arr[i];

            if(sum > maxSum){
                maxSum = sum;
            }

            if(sum < 0) sum = 0;
        }

        System.out.println("The maximum sum of a subarray is " + maxSum);
    }
}
