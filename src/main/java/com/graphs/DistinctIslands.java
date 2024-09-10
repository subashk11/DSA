package com.graphs;

import java.util.*;

public class DistinctIslands {
    public static void main(String[] args) {
        //This problem states to find the number of distinct islands in the grid.
        //1 -> land 0 -> water

        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1}
        };

        int n = grid.length;
        int m = grid[0].length;

        //use bfs to  traverse the grid and find the distinct islands.

        boolean[][] visited = new boolean[n][m];

        //Set to store unique islands
        Set<ArrayList<String>> ans = new HashSet<>();

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                 if(visited[i][j] == false && grid[i][j] == 1){
                     ArrayList<String> path = new ArrayList<>();
                     bfs(i, j, grid, visited, path, i , j);
                     ans.add(path);
                 }
            }
        }

        System.out.println("The number of distinct islands in the grid is: "+ans.size());
        System.out.println(ans.toString());

    }

    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void bfs(int row, int col, int[][] grid, boolean[][] visited, ArrayList<String> path, int row0, int col0){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int x = queue.peek().first;
            int y = queue.peek().second;
            queue.poll();
            visited[x][y] = true;

            for(int i = 0 ;i<4;i++){
                int rowX = x + delRow[i];
                int colY = y + delCol[i];
                if(rowX >= 0 && rowX < grid.length && colY >= 0 && colY < grid[0].length && visited[rowX][colY] == false && grid[rowX][colY] == 1) {
                    queue.add(new Pair(rowX, colY));
                    visited[rowX][colY] = true;
                    path.add((rowX - row0) + " " + (colY - col0));
                }
            }
        }

    }
}
