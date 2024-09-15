package com.functionalprogramming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_Problems_02 {

    // Streams problems
    public static void main(String[] args) {

        //1. Write a Java 8 program to concatenate two Streams?

        Stream s1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream s2 = Stream.of(11, 12, 13, 14, 15, 16);

        // result
        List<Integer> resList = Stream.concat(s1, s2).toList();
        System.out.println("1. Concat two streams : " + resList);

        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50, 60);
        List<Integer> list2 = Arrays.asList(11, 22, 33, 44, 55, 66);

        List<Integer> r = Stream.concat(list1.stream(), list2.stream()).toList();
        System.out.println("2. Concat two lists using streams : " + r);


        //2.  Java 8 program to perform cube on list elements and filter numbers greater than 50.

        List<Integer> l1 = Arrays.asList(7, 11, 15, 9, 12, 3, 22);

        // find the cube of each number.
        List<Integer> res1 = l1.stream().filter(num -> Math.pow(num, 3) > 50).collect(Collectors.toList());
        System.out.println("3. Find cubes of numbers which are greater than 50  : " + res1);


        //4. Parallel sort of primitive data type
        // used when to sort an array in parallel with other threads. large data sets
        int[] arr = {34, 12, 17, 57, 1, 8};

        Arrays.parallelSort(arr);

        System.out.println("4. sort an primitive array using parallelsort : ");
        // print the array
        Arrays.stream(arr).forEach(System.out::println);


        // 5.  How to use map to convert object into Uppercase in Java 8?
        String message = "heLlo";
        String convertedMessage = message.chars().mapToObj(ch -> Character.toUpperCase(Character.valueOf((char) ch))).collect(Collectors.toList()).stream().map(String::valueOf).collect(Collectors.joining());

        System.out.println("5. String value upper cased : " + convertedMessage);
        //6. convert a list of string to upper case
        List<String> strList1 = Arrays.asList("hello", "welcome");

        strList1.stream().map(str -> str.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);

        // 6. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
        List<User> users = new ArrayList<>();
        users.add(new User(23, "Arun"));
        users.add(new User(3, "Sai"));
        users.add(new User(23, "Balaji"));
        users.add(new User(23, "Suresh"));
        users.add(new User(23, "Ajay"));

        users.stream().sorted(Comparator.comparing(user -> user.name.toLowerCase())).collect(Collectors.toList()).stream().forEach(user -> System.out.println("user name : "+ user.name));
    }

}

class User {
    int id;
    String name;

    User(int id, String name){
        this.id = id;
        this.name = name;
    }
}


