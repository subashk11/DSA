package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static class pair{
        int first ;
        int second;
        pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        //get the number of islands in the given grid.
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1}
        };

        int result = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        result = getNumberOfIslands(grid, visited);

        System.out.println("The number of Islands in the given grid is: "+result);
    }

    public static int getNumberOfIslands(int[][] grid, int[][] visited){
        int result = 0;


        for(int i =0;i<grid.length;i++){
            for(int j =0 ;j<grid[i].length;j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    bfs(i, j, grid, visited);
                    result++;
                }
            }
        }

        return result;
    }

    public static void bfs(int row, int col, int[][] grid, int[][] visited){
        Queue<pair> queue = new LinkedList<>();

        queue.add(new pair(row, col));
        visited[row][col] = 1;

        while(!queue.isEmpty()){
            int x = queue.peek().first;
            int y = queue.peek().second;
            queue.poll();

            //check for all the 8 directions
            for(int dirRow = -1; dirRow <= 1; dirRow++){
                for(int dirCol = -1; dirCol <= 1; dirCol++){
                    int posX = x + dirRow;
                    int posY = y + dirCol;
                    if( posX >= 0 && posX<grid.length && posY >=0 && posY<grid[col].length && visited[posX][posY] == 0 && grid[posX][posY] == 1){
                        queue.add(new pair(posX, posY));
                        visited[posX][posY] = 1;
                    }
                }
            }
        }
    }
}
