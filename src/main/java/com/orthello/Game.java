package com.orthello;

import java.util.Scanner;

public class Game {

    // ORTHELLO -> A two player game played with two coins black and white
    // Rule -> Make a profitable move each time
    // Profitable -> If p1 is black, then p1 move should trap white between two black coins.
    // Allowed Moves -> only profitable move are allowed ie the move should trap at least one opponent coin, or else game will be end
    // Winner will be decided by highest number of coins on board at end,

    // All 8 directional captures are allowed


    // ENTITIES : GAME MANAGER, BOARD, PLAYERS
    Player p1;
    Player p2;
    public static void main(String[] args) {
        System.out.println("WELCOME TO ORTHELLO!");
        Game game = new Game();
        game.startGame();
    }

    // INITIALIZE GAME
    private void initializeGame(){
        try {
            System.out.println("ENTER PLAYER 1 NAME : ");
            Scanner scanner = new Scanner(System.in);
            String p1name = scanner.next();
            System.out.println("ENTER PLAYER 1 COIN 0 -> BLACK, 1 -> WHITE");
            int coin = scanner.nextInt();
            System.out.println("ENTER PLAYER 1 NAME : ");
            String p2name = scanner.next();

            p1 = new Player(p1name, coin);
            p2 = new Player(p2name, coin == 1 ? 0 : 1);

        } catch (Exception e) {
            System.out.println("ERROR WHILE INITIALIZE GAME : "+e);
        }
    }

    // START A GAME
    public boolean startGame(){
        try {
            // GET PLAYER CURRENT MOVE

            // CHECK FOR BOARD AS VALID MOVE

            // IF VALID UPDATE BOARD

            // CONTINUE UNTIL GAME ENDS
            Board board = new Board(1, 0);
            board.print();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR WHILE PLAYING GAME : "+ e);
            return false;
        }
    }
}
