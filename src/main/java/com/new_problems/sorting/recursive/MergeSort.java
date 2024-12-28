package com.new_problems.sorting.recursive;

import java.nio.file.ClosedWatchServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    // Algorithm is divide and conquer

    // divide the large array into two individual half
    // merge function will sort and merge the two half

    public static void main(String[] args) {
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };

        // recursive function call
        mergeSort(arr, n, 0, n-1);
        System.out.println("SORTED ARRAY : "+ Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int n, int low, int high){
        // base condition
        if(low>=high) return;

        // get the mid to divide into two half
        int mid = (low+high)/2;

        mergeSort(arr, n, low, mid);
        mergeSort(arr, n , mid+1, high);

        merge(arr, mid, low, high); // merge the array

    }

    public static void merge(int[] arr, int mid, int low, int high){
        int i = low;
        int j = mid+1;
        List<Integer> temp = new ArrayList<>();

        while(i <= mid && j <= high){
            // condition
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        // check and add left over items
        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }

        while(j<=high){
            temp.add(arr[j]);
            j++;
        }
//        System.out.println("Array passed is : "+ );
        System.out.println("sorted Array is : "+ temp.toString());

        for (int k = low; k <= high; k++) {
            arr[k] = temp.get(k - low);
        }
    }
}
