package com.tictactoe.game;

public class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public boolean makeMove(Board board, int position) {
        return board.updateBoard(position, symbol);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
