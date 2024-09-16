package com.new_problems.recursion;

import java.util.Arrays;

public class BasicRecursion {

    // Recursion - A function calls itself until a base condition is triggered which stops the recursive call.

    // Stack overflow - A recursive function calls itself without any break condition until stack memory is full

    public static void main(String[] args) {

        // Basic recursion problems

        // 1. print numbers from 1 to n
        int n = 10;

        printNumbers(1, n);

        // print N to 1
        printNNumbers(n);

        // Sum of N numbers
        int sum = sumOfN(n, 0);
        System.out.println("3. Sum of N numbers : "+ sum);

        // Factorial of N numbers
        int fact = factOfN(5);
        System.out.println("4. Factorial of N numbers is : "+ fact);

        int[] arr = {1,2,3,4,5};
        reverseArr(arr, 0 , arr.length -1);
        System.out.println("5. Reversed array : ");
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void printNumbers(int start, int end){

        // break condition
        if(start > end) return ;

        // Logic to be executed
        System.out.println(" Number is printed recursively : "+ start);

        // recursive function call
        System.out.println(" Printing numbers in reversed order : " );
        printNumbers(++start, end);
    }

    public static void printNNumbers(int n){
        if(n <= 0 ) return ;

        System.out.println(" Number in reversed order from N : "+ n);

        printNNumbers(--n);
    }

    // Sum of n numbers
    public static int sumOfN(int n, int sum){
        if(n == 0) return sum;
        sum += n;
        return sumOfN(--n, sum);
    }

    // Factorial of N numbers
    public static int factOfN(int n){
        if(n == 0 || n ==1 ) return 1;
        // 5 X fact (4), 4* fact(3), 3*fact(2), 2*fact(1)=1 2*1 = 2
        return n*factOfN(n-1);
    }

    // Reverse an array
    public static void reverseArr(int[] arr, int left, int right){
        if(left >= right) return ;

        // reverse logic
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right]= temp;

        reverseArr(arr, ++left, --right);
    }
}
