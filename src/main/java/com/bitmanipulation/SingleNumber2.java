package com.bitmanipulation;

import java.util.Arrays;

public class SingleNumber2 {

    //given a list on integers where every number occurs three times except for one, which only occurs once

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 3, 4, 5, 4, 3, 2, 4, 1};
        int result = 0;

        //1 Brute force approach Use hashmap and store the count.

        //2. Use XOR operation to get the number with single occurence.
        for(int i =0 ;i<31;i++){
            int cnt = 0;
            for(int j =0;j<arr.length;j++){
                if((arr[j] & (1<<i)) != 0){
                    cnt++;
                }
            }
            if(cnt % 3 == 1){
                result = result | (1<<i);
            }
        }

        System.out.println("The number with single occurence in the list is : " + result);

        //3. Use sorting to get the number with single occurence.
        Arrays.sort(arr);
        int result2 = 0;
        for(int i = 1; i < arr.length; i = i + 3){
            if(arr[i-1] != arr[i]){
                result2 = arr[i-1];
                break;
            }
        }
        result2 = arr[arr.length-1];
        System.out.println("The number with single occurence in the list is using sorting : " + result2);

    }
}
