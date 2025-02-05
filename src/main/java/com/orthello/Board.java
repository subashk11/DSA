package com.orthello;

public class Board {

    // THIS IS ORTHELLO BOARD
    // 8 X 8
    int p1Coin;
    int p2Coin;

    boolean[][] isVisited;
    int[][] board;

    public Board(int p1Coin, int p2Coin){
        this.p1Coin = p1Coin;
        this.p2Coin = p2Coin;
        isVisited = new boolean[8][8];
        board = new int[8][8];

        // RESET MAKE ALL CELLS TO -1
        for(int i = 0; i<8; i++){
            for (int j =0;j<8;j++){

                // MAKE 3,3 3,4 4,3 4,4 needs to be filled with adjacent colour
                if(i == 3 || i == 4) {
                    if(j == i){
                        board[i][j] = p1Coin;
                        isVisited[i][j] = true;
                    } else if(j == 3 || j == 4){
                        board[i][j] = p2Coin;
                        isVisited[i][j] = true;
                    } else board[i][j] = -1;
                } else board[i][j] = -1;
            }
        }
    }

    // CHECK FOR VALID MOVE
    public void print(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == -1) {
                    System.out.print(". "); // Empty cell
                } else if (board[i][j] == p1Coin) {
                    System.out.print("X "); // Player 1's coin
                } else if (board[i][j] == p2Coin) {
                    System.out.print("O "); // Player 2's coin
                }
            }
            System.out.println();
        }
    }

    // B SHOULD MOVE ONLY IT HAS CONTINUES OPPONENT W -> BWWB, BB IS NOT VALID

    public boolean move(int coin, int x, int y) {
        try {
            // base condition to check x and y
            if(x < 0 || x >=8 || y<0 || y>=8){
                System.out.println("NOT A VALID MOVE: ");
                return false;
            }

            // CHECK ON 8 DIRECTIONS
            int[] delX = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
            int[] delY = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

            boolean isCaptured = false;

            // MAIN LOOP TO MOVE IN ALL 8 DIRECTIONS FROM
            for(int i=0; i<delX.length; i++){
                // LOGIC TO CHECK AND MODIFY CELLS WHICH ARE CONQUERED

                int xCord = x + delX[i]; // GET FIRST X AND Y CO ORDINATES IN THE CURRENT DIRECTION
                int yCord = y + delY[i];

                // MOVE TOWARDS END AND CHANGE ITEMS IF IT IS PROFITABLE MOVE.
                while(xCord >= 0 && xCord < 8 && yCord >= 0 && yCord < 8){
                    // BASE CONDITION IF CELL IS NOT FILLED RETURN
                    if(board[xCord][yCord] == 0) break;
                    else if(board[xCord][yCord] == coin) { // IF IT IS END OR SYMBOL IS AT THE END
                        // CHECK FOR ANY ITEMS IS CAPTURED
                        if(isCaptured){
                            // MOVE TO NEXT DIRECTION WHILE MODIFY THE CAPTURED SECTIONS
                            int xCurr = delX[i];
                            int yCurr = delY[i];

                            while(xCurr != xCord && yCurr != yCord){
                                board[xCurr][yCurr] = coin;
                                xCurr += delX[i];
                                yCurr += delY[i];
                            }
                        }
                    } else { // OPPONENT SYMBOL
                        isCaptured = true;
                    }

                    xCord += delX[i];
                    yCord += delY[i];
                }

            }
        } catch (Exception error) {
            System.out.println("Error while checking validity of the move : "+ error);
        }
        return false;
    }
}
