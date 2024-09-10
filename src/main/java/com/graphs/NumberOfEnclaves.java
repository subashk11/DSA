package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        //This problem states that find the count of lands which are not connected to the boundary.
        //1 -> land 0 -> water

        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        //visited matrix to store the visited nodes.
        int[][] visited = new int[grid.length][grid[0].length];

        int[][] ans = new int[grid.length][grid[0].length];

        Queue<ReplaceOWithX.Pair> queue = new LinkedList<>();
        //boundary traversal
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                if(i==0 || j ==0 || i == grid.length-1 || j == grid[i].length-1) {
                    if (grid[i][j] == 1) {
                        queue.add(new ReplaceOWithX.Pair(i, j));
                        visited[i][j] = -1;
                    } else {
                        visited[i][j] = 0;
                    }
                }else{
                    visited[i][j] = 0;
                }
            }
        }

        //delRow and delCol arrays to traverse in 4 directions.
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        //bfs call
        bfs(queue, grid, visited, delRow, delCol);

        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    ans[i][j] = 1;
                }else{
                    ans[i][j] = 0;
                }
            }
        }

        //print the ans matrix
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void bfs(Queue<ReplaceOWithX.Pair> queue, int[][] grid, int[][] visited, int[] delRows, int[] delCols){
        while(!queue.isEmpty()){
            int x = queue.peek().first;
            int y = queue.peek().second;
            queue.poll();

            for(int i =0;i<4;i++){
                int newRow = x + delRows[i];
                int newCol = y + delCols[i];

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                    visited[newRow][newCol] = -1;
                    queue.add(new ReplaceOWithX.Pair(newRow, newCol));
                }
            }
        }
    }
}
