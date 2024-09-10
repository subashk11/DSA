package com.functionalprogramming;

import java.util.function.Function;

public class FunctionalInterface {

    // These are used to implement functional programming.
    // this will accept one argument.

    public static void main(String[] args) {
        Function<Integer, Double> function = a -> a/2.0;

        // First denotes input type -> T Function<T, R>
        // Second argument denotes the return type R

        // Functional interface has 4 methods .

        // 1. Apply

        // This will take one argument and return the result

        System.out.println(function.apply(15));

        // 2. andThen
        // Compose of functions where second parameterized function will be executed after the first one
        // there should be a function executed

        // covert a string number to integer in first lambda function and multiply by 2

        Function<String, Integer> fn1 = (input) -> {
            try{
                return Integer.parseInt(input);
            } catch (Exception e) {
                throw new RuntimeException(" Cannot convert to INteger");
            }
        };

        // andThen , chain the next function to the first function
        System.out.println(fn1.andThen((number) -> {
                    System.out.println(number * 2);
                    return number*2;
                }
        ));

        // apply to test or execute the function
        System.out.println(" 2 add then is triggered final result returned : "+ fn1.apply("10"));

        // 3. Compose
        // Works similar to addThen but here first the parameterized function
        // is executed first and then the first function will be executed

        Function<Integer, Integer> fn2 = (input) -> {
            try{
                return input/2;
            } catch (Exception e) {
                throw new RuntimeException(" Cannot convert to INteger");
            }
        };

        // compose will trigger first
        fn2 = fn2.compose(number -> number*7);


        System.out.println(" 3. Compose function example is trigger : "+ fn2.apply(12));


        // 4. identity - used when we need to return only the argument passed
        Function<Integer, Integer> fn3 = Function.identity();
        System.out.println("4. Identity is triggered : " + fn3.apply(24));
    }
}

