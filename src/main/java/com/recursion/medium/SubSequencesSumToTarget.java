package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

// return the subsequences which sum up to the target
public class SubSequencesSumToTarget {
    public static void main(String[] args) {
        //int target = 10;
        //int[] array ={3,7,5,4,3,2,10,1};

        int target =2;
        int[] array ={1,2,1};
        List<Integer> dataStructure = new ArrayList<Integer>();
        subSequencesToTarget(target, array, dataStructure, 0, 0);
    }

    private static void subSequencesToTarget(int target, int[] array, List<Integer> dataStructure, int sum, int index) {
        // base condition is the index should not be equal to the length of the array,
        // if it is equal break the recursion.
        if(index == array.length ){
            //check the sum of the subsequence is equal to the target

            // to return or print only one subsequence of the target,
            // maintain a boolean
            if(target == sum){
                System.out.println(dataStructure.toString());

                //return true;
            }
            return ;

            //return false;
        }

        //add the item and find all the possible subsequences.
        dataStructure.add(array[index]);
        sum += array[index];
        System.out.println("This the recursive call for adding the item "+ dataStructure.toString() + " sum is "+sum);
        subSequencesToTarget(target, array, dataStructure, sum, index+1);
        //if(subSequencesToTarget(target, array, dataStructure, sum, index+1) == true) return true;

        //remove the last item and find all the subsequences.
        dataStructure.remove(dataStructure.size()-1);
        sum -= array[index];
        System.out.println("This the recursive call by removing the item "+ dataStructure.toString() + " sum is "+sum);
        subSequencesToTarget(target, array, dataStructure, sum, index+1);
        //if(subSequencesToTarget(target, array, dataStructure, sum, index+1) == true) return true;

        //return false;
    }
}
