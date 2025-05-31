package com.functionalprogramming;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problems {

    // Remove duplicates from the list of items.
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 3, 7, 11, 11, 25, 1, 2, 6);

        Set<Integer> result = nums.stream().collect(Collectors.toSet());

        int[] nums1 = {2, 3, 3, 7, 11, 11, 25, 1, 2, 6};

        Set<Integer> res = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        // other approach
        List<Integer> res2 = nums.stream().distinct().collect(Collectors.toList());

        System.out.println("1. Result after removed duplicates using set interface : "+ result.toString());

        System.out.println("2. Result after removed duplicates using List interface : "+ res2.toString());


        // find the count of each character
        Stream<Character> chSeq = Stream.of('a', 'a', 'c', 'd', 'd', 'a', 'b', 'c', 'e');

        Map<Character, Long> resultMap = chSeq.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(Map.Entry<Character, Long> entry : resultMap.entrySet()){
            System.out.println(" key value is : "+ entry.getKey() + " counts are : "+ entry.getValue());
        }


        // 2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> list1 = Arrays.asList(11, 234, 34, 1, 56, 761, 31, 21);

        List<String> result2 = list1.stream().map(num -> num.toString()).filter(n -> n.charAt(0) == '1').collect(Collectors.toList());

        System.out.println("2. Problems 2 solution to get number starting with 1 : "+ result2);

        //3. Given the list of integers, find the first element of the list using Stream functions?

        Integer firstNum = list1.stream().findFirst().get();
        System.out.println(" 3. First item in the list using stream : "+ firstNum);

        // 4.  Given a list of integers, find the total number of elements present in the list using Stream functions?

        // Boxed -> use boxed when I want to convert a stream of primitive type into a wrapper class of collection interface.
        IntStream stream = IntStream.range(1, 10);
        System.out.println("4. Solution to problem to find the number of items present " + list1.stream().count());
        List<Integer> result3 = stream.boxed().collect(Collectors.toList());
        System.out.println("4. Use of Boxed to convert primitive to wrapper list : "+ result3);


        // 5. Given a list of integers, find the maximum value element present in it using Stream functions?
        // list1 as input

        // Max function will accept a comparator and returns a result of optional type based on the comparator
        Optional<Integer> maxNumber = list1.stream().max(Comparator.naturalOrder());
        if(maxNumber.isPresent()){
            System.out.println("5. Maximum number present in the list using max function and comparator : "+ maxNumber.get());
        }

        //6. Given a String, find the first non-repeated character in it using Stream functions?

        String message = "Hello! World program is executed";

        System.out.println(message.replaceAll("\\s+", ""));

        Character filterChar =  message.replaceAll("\\s+", "").chars().mapToObj( ch -> Character.toLowerCase((Character.valueOf((char) ch))))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                entrySet().stream().filter(item -> item.getValue() == 1L).map(key -> key.getKey()).findFirst().get();

        // 1. remove spaces between the strings. 2. Convert string to a stream of chars, IntStream.
        // 3. Convert Character to a object type
        // 4. Find count of each character using collectors grouping by, 1 arguments passes the character object, 2 counter for each.
        // 5. the above expression will return map as result.
        // 6. use entry set to traverse through each item in a stream.
        // 7. Apply filter to get count == 1.
        // 8. Return the first item present in the list.

        System.out.println(" 6. Value of ch : "+ filterChar);

        // 7.  Given a String, find the first repeated character in it using Stream functions?

        // use above string message as an example.

        // 1. Find the count of each character and return first character whose count is greater than one.
        Character ch1 = message.replaceAll("\\s+", "").chars().mapToObj( ch -> Character.toLowerCase(Character.valueOf((char) ch)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter( item -> item.getValue() > 1L).map(key -> key.getKey()).findFirst().get();

        // Use linked hashmap to main the order

        System.out.println("7. First character whose occurence is more than once : "+ ch1);


        // 8. Given a list of integers, sort all the values present in it using Stream functions?
        // list1 as an input.

        List<Integer> sortedList = list1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        System.out.println("8. Result for sorted list : "+ sortedList);

        // 9. Given a list of integers, sort all the values present in it in descending order using Stream functions?

        List<Integer> reversedOrderSort = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("9. Result for sorted list in reversed Order : "+ reversedOrderSort);

        //10. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

        // nums as input
        Map<Boolean, List<Integer>> filteredResult = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().collect(Collectors.partitioningBy( item -> item.getValue()>=2L, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        System.out.println( " filtered list of items count greater than 2 : "+ filteredResult);

    }
}
