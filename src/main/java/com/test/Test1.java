package com.test;

public class Test1 {

    // array of 0 and 1,

    // sort array

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 1, 0, 1, 1, 0};

        // Approach.
        // 1. Trackker or pointers to find index.
        // 2.

        int n = arr.length;
        int left = 0;
        int right = n-1;
        while(left < arr.length){
            if(arr[left] == 1){
                // swap current item with last
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                right--;
            } else if(arr[left] == 0) {
                left++;
            }
        }

        for(int i = 0; i<n;i++){
            System.out.println(i + " : " + arr[i]);
        }
    }
}
