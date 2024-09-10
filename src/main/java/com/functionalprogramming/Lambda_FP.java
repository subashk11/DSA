package com.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda_FP {

    // Lambda's are anonymous functions which will run parallel
    // Does not have a name, has parameters and body

    public static void main(String[] args) {
        Integer[] nums = {2,3,4,5,6,7,8};

        // lambdas are defined with ->
        List<Integer> arr1 = new ArrayList<>(List.of(nums));
        arr1.forEach(num -> System.out.println("Number is printed using lambda : " + num));

        // Anonymous function
        Runnable runner = () -> {
            System.out.println(" Inside anonymous function call using functional Interface ! ");
        };

        runner.run();

        // Using method reference
        // println method is passed as an argument to forEach iterable interface.

        // Does not accepts an argument like lambda print("hello")
        arr1.forEach(System.out::print);

        // Pure functions : These are functions which will give same result for same arguments for eg: calculator
        // These functions does not use any external values or attributes, they will do the logic on the arguments passed
        // does not mutate the arguments.

        // Closure is a pure function which does not accept any external attributes to be passed in the lambdas

        List<Integer> nums2 = Arrays.asList(11, 22, 33, 44,
                55, 66, 77, 88,
                99, 100);

        // Finding even numbers and doubling return their total sum
        System.out.println("\nPrinting the sum of even numbers using lambdas");
        System.out.println(nums2.stream()
                .filter(num -> num%2 == 0).mapToInt( e -> e * 2).sum());


        // 1. Stream is used to traverse or pass one item by item
        // 2. Filter layer is used to apply condition logic to the steam of number.
        // 3. mapToInt is closure which will apply logic or manipulate the number Note : wont change the list item
        // 4. Sum will return the sum of above items returned after applying those logic

        int factor = 2;

        //        System.out.println(nums2.stream()
//                .filter(num -> num%2 == 0).mapToInt( e -> e * factor).sum());

        factor = 3;

        // If we use external factors like factor variable it won't accept for
        // mutation of values because factor is updated later on this code.
        // It will accept final variables
    }
}
