package ticTacToe;

/*
Problem Statement:
Player class stores player details
such as name and symbol.
*/

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    // O(1)
    public String getName() {
        return name;
    }

    // O(1)
    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    // O(1)
    public char getSymbol() {
        return symbol;
    }

    // O(1)
    public void setSymbol(char symbol) {
        if (symbol != '\0') {
            this.symbol = symbol;
        }
    }
}