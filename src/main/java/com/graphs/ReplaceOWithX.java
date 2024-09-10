package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ReplaceOWithX {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {

        //In this problem a matrix of 'X' and 'O' is given. We have to replace all 'O' with 'X'
        //which are surrounded by 'X'.

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        //Traverse through the boundary and add it to the queue and mark the linked 'O' with '1'.
        int[][] visited = new int[board.length][board[0].length];
        Queue<Pair> queue = new LinkedList<>();
        //boundary traversal
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if((i == 0 || j == 0 || i == board.length-1 || j == board[i].length-1) && board[i][j] == 'O'){
                    queue.add(new Pair(i, j));
                    visited[i][j] = 1;
                }else if(board[i][j] == 'O') {
                    visited[i][j] = 0;
                }else if(board[i][j] == 'X'){
                    visited[i][j] = -1;
                }
            }
        }

        //4 direction traversal
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        //Then traverse through the matrix and replace 'O' with 'X' and '1' with 'O'.
        bfs(queue, board, visited, delRow, delCol);

        //print the ans matrix

        char[][] ans = new char[board.length][board[0].length];

        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[i].length;j++){
                if(visited[i][j] == 1){
                    ans[i][j] = 'O';
                }else if(visited[i][j] == 0){
                    ans[i][j] = 'X';
                }else if(visited[i][j] == -1){
                    ans[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static void bfs(Queue<Pair> queue, char[][] board, int[][] visited, int[] delRow, int[] delCol){
        while(!queue.isEmpty()){
            int x = queue.peek().first;
            int y = queue.peek().second;
            queue.poll();

            for(int i = 0;i<4;i++){
                int newX = x + delRow[i];
                int newY = y + delCol[i];

                if(newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && visited[newX][newY] == 0){
                    visited[newX][newY] = 1;
                    queue.add(new Pair(newX, newY));
                }
            }
        }
    }
}
