package com.recursion;

//return the combination of the items in the list that sums up the target.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [2,1,4] target =4,
// [2,2], [1,1,1,1], [4], [2,1,1]
public class CombinationSum {

    public static void main(String[] args) {
        int target =2;
        int[] array ={2,1,4,1};

        List<Integer> data = new ArrayList<Integer>();

       // combinationSumI(target, array, data, 0);
        Arrays.sort(array);
        combinationSumII(target, array, data,0);
    }

    private static void combinationSumI(int target, int[] array, List<Integer> data, int index) {
        if(index == array.length){
            if(target == 0){
                System.out.println(data.toString());
            }
            return;
        }

        //loop or add the current item until it is greater than the target and reduce the target
        if(array[index] <= target){
            data.add(array[index]);
            combinationSumI(target-array[index], array, data, index);
            data.remove(data.size()-1);
        }
        combinationSumI(target,array,data,index+1);
    }

    private static void combinationSumII(int target, int[] array, List<Integer> data, int index) {
        if(target == 0){
            System.out.println(data.toString());
            return;
        }

        for(int i = index; i < array.length; i++){
            if(i > index && array[i] == array[i-1])continue;

            if(array[i] > target) return;

            data.add(array[i]);
            combinationSumII(target-array[i], array, data, i+1);
            data.remove(data.size()-1);

        }
    }
}
