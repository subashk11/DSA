package com.maths;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = 17;
        boolean isPrime = isPrime(n);
        if(isPrime){
            System.out.println(n + " is a prime number");
        }else{
            System.out.println(n + " is not a prime number");
        }
    }

    private static boolean isPrime(int n) {
        boolean isPrime = false;

        if(n == 1) return false;

        if(n == 2 || n== 3) return true;

        if(n % 2 ==0 || n%3 == 0) return false;

        for(int i = 5; i*i<=n; i++){
            if(n % i == 0) return false;
        }

        return true;
    }
}
