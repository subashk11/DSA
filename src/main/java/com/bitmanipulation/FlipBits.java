package com.bitmanipulation;

public class FlipBits {

    //Flip the bits in the input number to achieve the goal number

    public static void main(String[] args) {
        int a = 10, b = 15;

        int cnt = 0;

        //find the xor of both the input numbers and
        //the bits which are not equal in both the numbers can be ones in the result
        int xor = a ^ b;

        //to find the count of the bits divide it by 2.
        while(xor > 0) {
            if(xor % 2 == 1){
                cnt++;
            }
        }

        System.out.println("Number of bits to be flipped to convert " + a + " to " + b + " : " + cnt);

    }
}
