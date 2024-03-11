package com.maths;


//reverse the provided number. Find the number is a palindrome
public class ReverseANumber {

    public static void main(String[] args) {
        int n = 23567;

        int n2 = 7667;

        //o/p is 76532
        int result = reverseANumber(n);
        int result2 = reverseANumber(n2);

        System.out.println("The reversed number is "+result);

        //Provided Number is a palindrome or not

        if(result2 == n2){
            System.out.println("The number is a palindrome");
        }else{
            System.out.println("The number is not a palindrome");
        }
    }

    public static int reverseANumber(int n) {
        int number = 0;

        while(n > 0) {
            int lastDigit = n % 10;
            number = number * 10 + lastDigit;
            n = n / 10;
        }
        return number;
    }
}
