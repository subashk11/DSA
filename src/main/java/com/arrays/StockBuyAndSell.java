package com.arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        // Stock Buy and Sell
        // Find the maximum profit by buying and selling the stock
        int[] arr = {7, 1, 5, 3, 6, 4};

        int profit= 0;
        int min = arr[0];
        for(int i =1;i<arr.length;i++){
            int cost = arr[i]-min;
            profit = Math.max(profit,cost);
            min = Math.min(min,arr[i]);
        }
        System.out.println("The maximum profit is: "+ profit);
    }
}
