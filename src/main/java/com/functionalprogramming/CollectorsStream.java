package com.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsStream {

    // Collectors are used to serve the purpose of grouping those stream information
    // into a collection, partition, grouping and so on

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        // Collectors utility class will provide the following methods

        // 1. toList() -> used to transform or group the stream data into a list interface
        List<Integer> result = list.stream().map(item -> Integer.parseInt(item)).collect(Collectors.toList());

        System.out.println("1. toList() is triggered : "+ result.toString());

        // 2. toSet() -> same as toList but it will save it in a set interface
        // Streams are used to create a stream of data
        Stream<Integer> nums = Stream.of(10, 20, 30, 40, 50);

        Set<Integer> res1 = nums.collect(Collectors.toSet());
        System.out.println("2. toSet() is triggerd : "+ res1);

        // 3. joining is used to join char sequence into a string or stream of string/char to string
        Stream<Character> message = Stream.of('H','E','L','L','O');
        // joining will only accept characterInterface like String, StringBuilder and Stringbuffer
        String helloMessage = message.map(ch -> new String(String.valueOf(ch))).collect(Collectors.joining());

        System.out.println("3. joining() is triggered : "+ helloMessage);

        //4. PartitionBy is used to partition the array into two segments of map one is false and other is true
        Map<Boolean, List<Integer>> seggreagatedList = list.stream().map(item -> Integer.parseInt(item)).collect(Collectors.partitioningBy(n -> n%2 == 0));

        System.out.println(" 4. partition is triggered : ");
        for(Map.Entry<Boolean, List<Integer>> entry : seggreagatedList.entrySet()){
            System.out.println(" key is : "+ entry.getKey() + " values are : "+ entry.getValue());
        }

        // 5. Groupinginby are used to group the values form of map
        Stream<String> seq = Stream.of("Apple", "Orange", "Banana", "Apricot", "Cherry","Blueberry");

        Map<Character, List<String>> filteredList = seq.collect(Collectors.groupingBy(item -> item.charAt(0)));
        System.out.println(" 5. Groupinginby() is triggered");
        for(Map.Entry<Character, List<String>> entry : filteredList.entrySet()){
            System.out.println(" key value is : "+ entry.getKey() + " Grouped values are : "+ entry.getValue());
        }
    }
}
