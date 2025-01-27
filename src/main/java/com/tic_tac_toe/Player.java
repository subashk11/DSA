package com.tic_tac_toe;

public class Player {
    // STORE PLAYER SPECIFIC INFORMATION
    private String name;
    private Character symbol;

    public Player(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public Player() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
}
