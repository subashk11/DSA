package com.new_problems.recursion;

public class PowerOfNumber {

    // Find the power of a number

    // Cases -> exponent may be a negative or positive or zero.
    // base -> will be of type double.

    public static void main(String[] args) {
        int exponent = -2;
        double base = 2.02;

        double result = powX(base, exponent);

        System.out.println("Result is : "+ result);
    }

    public static double powX(double base, int exponent){
        // Base case if base is 0
        if(base == 0){
            return 0;
        }

        // Recursive Function call
        double powerRes = powerHelper(base, exponent);

        return powerRes;
    }

    public static double powerHelper(double base, int exponent){
        // Applying exponents by squaring algorithm

        // States that if exponent is even, split it into half and square the half values -> base^exponent/2 * base^exponent/2;
        // if odd apply same logic but one half has one exponent greater so multiply base with it.

        // Base condition
        if(exponent == 0) return 1;

        // Apply algorithm to get the half of exponent
        double half = powerHelper(base, exponent/2);

        if(exponent % 2 == 0){
            return half*half;
        } else {
            return half*half*base;
        }
    }
}
