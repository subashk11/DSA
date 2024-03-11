package com.maths;


//Give the number of digits in the number
public class CountDigits {

    public static void main(String[] args) {
        int n = 123456789;
        int result = countDigits(n);
        System.out.println("The number of digits is "+result);
    }

    private static int countDigits(int n) {
        int digits = 0;

        //This loop will remove digits at the last position until the number becomes zero.
        while(n >0){
            digits++;
            n = n/10;
        }

        return digits;
    }
}
