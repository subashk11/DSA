package com.bitmanipulation;


import java.util.ArrayList;
import java.util.List;

//Powerset is used to get the subsets of a given set
public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<ArrayList<Integer>> result = new ArrayList<>();

        getSubsets(arr, result);
        for(ArrayList<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static void getSubsets(int[] arr, List<ArrayList<Integer>> result) {

        int n = arr.length;
        int noOfSubsets = (int)Math.pow(2, n);

        //loop to traverse through the number of subsets
        for(int num = 0; num < noOfSubsets; num++){

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((num & (1 << i)) != 0) {
                    list.add(arr[i]);
                }
            }
            result.add(list);
        }
    }
}
