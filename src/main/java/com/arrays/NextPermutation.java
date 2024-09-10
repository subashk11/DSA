package com.arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        // print the next permutation of the given array
        int[] arr1 = {2, 1, 5, 4, 3, 0, 0};
        int[] arr = {1, 2, 3};

        // find the break point where item is smaller to the next item
        int index = -1;
        int n = arr.length;

        for(int i = n-2;i >=0;i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }

        //find the first element greater than the break point.
        //swap the break point element with the first greater element.
        for(int i = n-1;i>=index;i--){
            if(arr[i] > arr[index]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        //reverse the array from the break point to the end.
        int low = index+1;
        int high = n-1;
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        System.out.println("The next permutation is: "+ Arrays.toString(arr));
    }
}
