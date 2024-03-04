package com.recursion;

//Given an array and we need to reverse the array using recursion.
public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(0,arr.length-1,arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void reverseArray(int left, int right, int[] arr) {
        if(left >= right) return; //Break condition left index should be less than right index.
        swap(left, right, arr); //swap the left and right index items
        reverseArray(left+1, right-1, arr); // repeat the swap for next indexes.
    }

    private static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
