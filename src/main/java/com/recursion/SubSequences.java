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
        printSubSequences(array, 0, data);
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
}
