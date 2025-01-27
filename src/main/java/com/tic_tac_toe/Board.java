package com.tic_tac_toe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    // X = 1, O = 0

    // STORE PLAYERS SYMBOL BOARD STATUS
    private static final int size = 3;
    private Character p1Symbol;
    private Character p2Symbol;
    private Character[][] board ;
    private static final Integer numberOfCells = 9;
    private Integer filledCells = 0;
    private boolean[][] isVisited ;

    public Board(Character p1Symbol, Character p2Symbol) {
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
        // FILL BOARD VALUES WITH -1;
        board = new Character[size][size];
        isVisited = new boolean[size][size];

        for(int i =0;i < size; i++) {
            for(int j =0; j< size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // PRINTING
    public void printBoard() {
        try {
            for(int i = 0; i<size; i++){
                int[] row = board[i];
                for(int j = 0;j<size; j++){
                    StringBuilder str = new StringBuilder();
                    str.append("[");
                    if(row[j] == 'X') {
                        str.append(" X ");
                    } else if(row[j] == 'O') {
                        str.append(" O ");
                    } else {
                        str.append("   ");
                    }
                    str.append("]");
                    System.out.print(str.toString());
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error while printing board : "+ e);
        }
    }

    // CHECK UTILITY
}
