package com.recursion;


// subsequences are a list of contiguous or non contiguous items in a sequence array,
// subsequences maintains the order of array items.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [3,1,2] => {3},{1},{2},{3,1},{3,2},{1,2},{3,1,2},{}
// {2,1} is not a subsequence as it does not follow the order of array.
public class SubSequences {

    public static void main(String[] args) {
        int[] array ={3,1,2};
        List<Integer> data = new ArrayList<>();

        //create the recursion function to pring the array
//        printSubSequences(array, 0, data);
        subsets2(array);
    }

    public static void printSubSequences(int[] array, int index, List<Integer> dataList){

        //base condition , the index should not be equal or greater than array length.
        if(index == array.length){
            System.out.println(dataList.toString());
            return;
        }

        //add the item and print all the possible subsequence of the added items.
        dataList.add(array[index]);
        printSubSequences(array, index+1, dataList);

        //remove the item and print all the possible subsequence of the removed items.
        dataList.remove(dataList.size() -1);
        printSubSequences(array, index+1, dataList);
    }



    public static void subsets2(int[] nums) {

        // Apply the rule power set -> take and not take.
        // Subsequence / subsets -> can skip items but maintain items position/ order cannot be changed.

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        List<Integer> tracker = new ArrayList<Integer>();
        recursiveFunctionCall(0, n, nums, tracker, result);

        System.out.println(" result is : " + result);
//        return result;
    }

    public static void recursiveFunctionCall(int idx, int n, int[] nums, List<Integer> tracker, List<List<Integer>> list){
        // Index is used to traverse through nums, base i == n add and return
        if(idx == n){
            list.add(tracker);
            System.out.println("tracker : "+ list);
            return;
        }

        // Take
        tracker.add(nums[idx]);
        idx = idx+1;
        recursiveFunctionCall(idx, n, nums, tracker, list);

        // Not take
        tracker.remove(tracker.size() - 1);
        recursiveFunctionCall(idx, n, nums, tracker, list);
    }
}
