package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearsetCell {

    static class Pair{
        int first;
        int second;
        int distance;
        Pair(int first, int second, int distance){
            this.first = first;
            this.second = second;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        //This problem is to find the minimum distance of the nearest cell of 1 to 0.
        //0 -> empty cell 1 -> cell with 1
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 1}
        };

        int n = grid.length;
        int m = grid[0].length;

        //visited array to keep track of the visited nodes.
        boolean[][] visited = new boolean[n][m];

        //Answer array to store the minimum distance of the nearest cell of 1 to 0.
        int[][] ans = new int[n][m];

        //Queue to maintain the nodes.
        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    ans[i][j] = 0;
                    visited[i][j] = true;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        int[] delRows = {-1, 0, 1, 0};
        int[] delCols = {0, 1, 0, -1};

        //bfs call
        bfs(grid, ans, visited, delRows, delCols, queue);

        //print the ans
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(int[][] grid, int[][] ans, boolean[][] visited, int[] delRows, int[] delCols, Queue<Pair> queue){
        while(!queue.isEmpty()){
            int x = queue.peek().first;
            int y = queue.peek().second;
            int distance = queue.peek().distance;
            queue.poll();

            for(int i = 0 ;i<4; i++){
                int dirX = x + delRows[i];
                int dirY = y + delCols[i];

                if(dirX >= 0 && dirX < grid.length && dirY >= 0 && dirY < grid[0].length && !visited[dirX][dirY] && grid[dirX][dirY] == 0){
                    visited[dirX][dirY] = true;
                    ans[dirX][dirY] = distance + 1;
                    queue.add(new Pair(dirX, dirY, distance + 1));
                }
            }
        }
    }
}
