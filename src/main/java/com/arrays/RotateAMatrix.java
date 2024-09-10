package com.arrays;

public class RotateAMatrix {
    public static void main(String[] args) {
        // Rotate a matrix by 90 degree
        // 2d array
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int n = arr.length;
        int m = arr[0].length;

        int[][] temp = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                temp[j][n-i-1] = arr[i][j];
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
