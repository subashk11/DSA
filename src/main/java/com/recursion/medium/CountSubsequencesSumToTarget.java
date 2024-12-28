package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

// return the count of subsequences which is equal to the target.
public class CountSubsequencesSumToTarget {

    public static void main(String[] args) {
        int target = 10;
        int[] array ={3,7,5,4,3,2,10,1};
        
        int count = countSubsequencesToTarget(target, array,0, 0);
        System.out.println(count);
        
    }

    private static int countSubsequencesToTarget(int target, int[] array, int sum, int index) {

        //base condition if index is equal to the length of the array
        if(index == array.length){
            if(sum == target){
                return 1;
            }else return 0;
        }

        //add an item to the sum
        sum += array[index];
        int left = countSubsequencesToTarget(target, array, sum, index+1);
        sum -= array[index];
        int right = countSubsequencesToTarget(target, array, sum, index+1);

        return  left + right;
    }
}
