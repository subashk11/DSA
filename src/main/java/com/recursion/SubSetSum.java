package com.recursion;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//return the sum of all the subsets in the provided array.
public class SubSetSum {

    public static void main(String[] args) {

        int[] arr= {3,1,4};

        List<Integer> dataStructure=new ArrayList<Integer>();

        subSetCount(0, arr, dataStructure, 0);

        Collections.sort(dataStructure);

        System.out.println(dataStructure.toString());
    }

    private static void subSetCount(int index, int[] arr, List<Integer> dataStructure, int sum) {

        if(index == arr.length){
            dataStructure.add(sum);
            return;
        }

        sum += arr[index];
        subSetCount(index +1, arr, dataStructure, sum);

        sum -= arr[index];
        subSetCount(index +1, arr, dataStructure, sum);
    }
}
