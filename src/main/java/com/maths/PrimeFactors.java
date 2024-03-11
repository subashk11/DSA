package com.maths;

public class PrimeFactors {

    public static void main(String[] args) {
        int n = 12;
        primeFactors(n);
    }

    private static void primeFactors(int n) {
        System.out.println("The prime Factors for the number "+n+" is : ");
        for(int i = 1; i*i <= n; i++) {
            if(n% i ==0 && isPrime(i)) {
                System.out.println(i);
                int div = n / i;
                if (isPrime(div)) {
                    System.out.println(div);
                }
            }
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
