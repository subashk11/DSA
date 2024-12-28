package com.recursion.medium;

public class PerfectSum {

    public static void main(String[] args) {

        // Your code goes here
        int[] arr = {5,2, 3, 10, 6, 8};
        int n = 6;
        int sum = 10;


        // use powerset approach
        int count = 0;
        int result = recursiveFunctionCall(arr, n, sum, count, 0, 0);
        System.out.println(" Count : " + result);
    }




    public static int recursiveFunctionCall(int[] arr, int n, int target, int count, int idx, int sum){

        // Base condition, break when idx == n
        if(idx == n){
            //Add or increment count
            if(sum == target){
                System.out.println(" sum : " + sum);
                count = count+1;
            }
            return count;
        }

        // take
        int take = recursiveFunctionCall(arr, n, target, count, idx+1, sum+arr[idx]);

        // not take
        int notTake = recursiveFunctionCall(arr, n, target, count, idx+1, sum);
        return take + notTake;
    }
}
