package com.functionalprogramming;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OddAndEven {

    // Separate odd and even numbers
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList( 13, 7, 6, 8, 22, 31, 44, 52, 18);

        // Collectors are used to group or accumulate the values that are filtered in the stream
        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));

        System.out.println(" Result : "+ result);

       for(Map.Entry<Boolean, List<Integer>> entrySet : result.entrySet()){
           System.out.println(" Key is : "+ entrySet.getKey() + " and Value is : "+ entrySet.getValue());
       }
    }
}
