package com.maths;


//return the count of zeros for the factorial of a number.
public class TrailingZeros {
    public static void main(String[] args) {
        int n = 100;
        //int factorial = getFactorial(n);
        //int count = countTrailingZeros(n);
        int count = countTrailingZerosOptimized(n);
        System.out.println(" The count of trailing zeros in the number "+ count);
    }

    private static int getFactorial(int n) {
        int factorial = 1;
        for(int i= 2;i < n;i++){
            factorial = factorial * i;
        }
        return factorial;
    }

    private static int countTrailingZeros(int n) {
        int result = 0;
        while(n>0){
            int lastDigit = n % 10;
            if(lastDigit == 0){
                result++;
            }else{
                return result;
            }
            n = n / 10;
        }
        return result;
    }

    //optimized solution
    private static int countTrailingZerosOptimized(int n){
        int count = 0;

        for(int i =5; i<= n; i = i *5){
            count = count + n/i;
        }

        return count;
    }
}
