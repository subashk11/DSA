package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair{
        int first;
        int second;
        int time;
        Pair(int first, int second, int time){
            this.first = first;
            this.second = second;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        //This problem deals with the rotten oranges and fresh oranges in a grid.
        //We need to find the minimum time to rot all the oranges in the grid.

        //0 -> empty cell 1 -> fresh orange 2 -> rotten orange
        int[][] grid = {
                {2, 1, 1},
                {2, 1, 0},
                {0, 1, 2}
        };

        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int minTime = 0;

        Queue<Pair> queue = new LinkedList<>();

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    ans[i][j] = 2;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        //bfs call as we need to travel simultaneously in all the directions.
        bfs(queue, grid, ans, delRow, delCol, minTime);

        System.out.println(minTime);
    }

    public static void bfs(Queue<Pair> queue, int[][] grid, int[][] ans, int[] delRow, int[] delCol, int minTime){
        int min = 0;
        while(!queue.isEmpty()){
            int x = queue.peek().first;
            int y = queue.peek().second;
            int t = queue.peek().time;
            queue.poll();


            int n = grid.length;
            int m = grid[0].length;

            for(int i = 0;i<4;i++){
                int rowX = x + delRow[i];
                int colY = y + delCol[i];

                if(rowX >=0 && rowX<n && colY >=0 && colY<m && grid[rowX][colY] == 1 && ans[rowX][colY] != 2){
                    ans[rowX][colY] = 2;
                    queue.add(new Pair(rowX, colY, t+1));
                    minTime = Math.max(minTime, t+1);
                    min = t+1;
                }
            }


        }
        System.out.println(min);
    }
}
