package com.arrays;

public class CheckArraySortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {60, 30, 40, 50, 10, 20};
        boolean isSorted = true;

        int cnt = 0;
        int n = arr.length;

        //check the array has a one high pointer and the other pointers next to it are low
        for(int i = 0; i < arr.length ; i++) {
            if(arr[i] > arr[ (i+1) %n]) {
                cnt++;
            }

            //check the cnt should be less than 1
            if(cnt > 1) {
                isSorted = false;
                break;
            }
        }
        System.out.println("The array is sorted and rotated: " + isSorted);
    }
}
