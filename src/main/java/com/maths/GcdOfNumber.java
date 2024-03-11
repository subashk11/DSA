package com.maths;

public class GcdOfNumber {

    //Find the gcd of the provided numbers

    //euclidean algorithm is used here
    //gcd(a,b) = gcd(a-b, b) where a > b ;

    public static void main(String[] args) {
        int n1 = 55;
        int n2 = 10;
        int gcd = gcd(n1, n2);
        int optSolution = gcdOptimized(n1, n2);
        System.out.println("The gcd of the two numbers is " + gcd);
        System.out.println("The gcd of the two numbers is " + optSolution);
    }

    private static int gcd(int n1, int n2) {

        while(n1 != n2) {
            if(n1 > n2) {
                n1 = n1 - n2;
            } else {
                n2 = n2 - n1;
            }
        }

        return n1;
    }

    //optimized solution
    private static int gcdOptimized(int n1, int n2) {

        if(n1 > 0 && n2 > 0) {
            if(n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }

        if(n1 ==0) return n2;
        else return n1;
    }

}
