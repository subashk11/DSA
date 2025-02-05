package com.tic_tac_toe;

import java.util.Scanner;

public class Game {

    // THIS CLASS IS USED TO MANAGE GAME.

    private Player player1;
    private Player player2;

    private static Board board;

    public Game() {
        board = new Board('X', 'O');
    }

    public static void main(String[] args) {
        // GAME IS STARTED
        System.out.println("GAME IS STARTED!");
        Game game = new Game();
        game.initializeGame();
        System.out.println();

    }

    public void initializeGame() {
        try {



            System.out.println("GAME IS STARTED ! "+ player1.getName() + " : SYMBOL IS : "+ player1.getSymbol() +" \n"+player2.getName() + " : SYMBOL IS : "+ player2.getSymbol() );

        } catch (Exception e) {
            System.out.println("Error while starting a game : "+ e);
        }
    }

    // UTILITY FUNCTION TO CHECK PASSED INPUT IS VALID CHARACTER AND CHARACTER IS EITER X OR O;
    public static boolean checkInput(String symbol) {
        if(symbol.trim().length() != 1) return false;

        char ch = symbol.charAt(0);
        return ch == 'X' || ch == 'O';
    }

    // START GAME TO GET ROW AND COLUMN INDEX
    public void startGame() {
        try {
            // GET PLAYER DETAILS
            System.out.println("WELCOME TO TIC-TAC-TOE!");
            System.out.println("PLAYER 1 NAME : ");
            Scanner sc = new Scanner(System.in);
            String p1Name = sc.next();

            System.out.println("PLAYER 1 CAN SELECT EITHER OF X OR O AS SYMBOL TO PROCEED TO GAME : ");
            String p1Symbol = sc.next();

            System.out.println("P1 CHARACTER IS : "+ p1Symbol);
            p1Symbol = p1Symbol.toUpperCase();
            boolean isValidInput = checkInput(p1Symbol);
            if(!isValidInput) {
                System.out.println("PLEASE ENTER A VALID INPUT!");
                return ;
            }

            this.player1 = new Player(p1Name, p1Symbol.charAt(0));

            this.player2 = new Player();
            if(p1Symbol.equals("X")) {
                player2.setSymbol('O');
            } else {
                player2.setSymbol('X');
            }

            System.out.println("ENTER PLAYER 2 NAME : ");
            String p2name = sc.next();
            player2.setName(p2name);

        } catch (Exception e) {
            System.out.println("Error while starting game : "+e);
        }
    }


}
