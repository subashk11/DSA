package com.arrays;


// Find the largest element in the array
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 4, 9, 9, 6, 3, 8, 1};
        int greatest = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > greatest) {
                greatest = arr[i];
            }
        }

        System.out.println("The largest element in the array is " + greatest);

        // To find the second largest
        int secondLargest = -1;

        for(int i =0;i<arr.length;i++){
            if(arr[i] > secondLargest && arr[i] != greatest){
                secondLargest = arr[i];
            }
        }
        System.out.println("The second largest element in the array is " + secondLargest);

        //optimal solution for second larges
        int sLargest = -1;
        int fLargest = arr[0];

        for(int i =0 ;i< arr.length;i++){
            if(arr[i] > fLargest){
                sLargest = fLargest;
                fLargest = arr[i];
            }
            if(arr[i] > sLargest && arr[i] < fLargest){
                sLargest = arr[i];
            }
        }

        System.out.println("The second largest element in the array is " + sLargest );
    }
}
