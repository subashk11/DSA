package com.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber1 {

    // get the number in the list which has one occurence all other number will have two occurence in the list
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 3, 4, 5, 4};
        int result = 0;

        result = getSingleNumber(arr);
        System.out.println("The number with single occurence in the list is using bruteforce : " + result);

        int result1 = 0;
        for(int i : arr) {
            result1 = result1 ^ i;
        }
        System.out.println("The number with single occurence in the list is : " + result1);

    }

    private static int getSingleNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i : arr) {
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }

        //traverse through the map and get the number with single occurence
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                result =  entry.getKey();
            }
        }

        return  result;
    }
}
