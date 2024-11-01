package com.mahmoud_ahmed.ui;

import com.mahmoud_ahmed.model.Board;
import com.mahmoud_ahmed.model.Player;
import java.util.HashSet;
import java.util.Set;

public class Console {
    private final ConsoleDisplay display;
    private final ConsoleInput input;
    private final Set<Character> usedSymbols;

    public Console() {
        this.display = new ConsoleDisplay();
        this.input = new ConsoleInput();
        this.usedSymbols = new HashSet<>();
    }

    public void displayBoard(Board board) {
        display.clear();
        display.println(BoardFormatter.format(board));
    }

    public void displayPlayerTurn(Player player) {
        display.println("Player Turn: " + player.getName());
        display.println("Player Symbol: " + player.getSymbol());
    }

    public void displayWinner(Player player) {
        display.println("Player " + player.getName() + " wins!");
    }

    public void displayDraw() {
        display.println("Game ended in a draw!");
    }

    public void displayInvalidMoveError() {
        display.println("Invalid move! Please try again.");
    }

    public Player createPlayer(int playerNumber) {
        display.println("=== Player " + playerNumber + " Setup ===");
        String name = getUniquePlayerName();
        char symbol = getUniquePlayerSymbol();
        usedSymbols.add(symbol);
        return new Player(name, symbol);
    }

    public int getMoveInput(int maxPosition) {
        return input.getIntegerInput(
                "Enter your move (1-" + maxPosition + "): ",
                1,
                maxPosition);
    }

    private String getUniquePlayerName() {
        while (true) {
            String name = input.getStringInput("Enter player name: ");
            if (isValidPlayerName(name)) {
                return name;
            }
            display.println("Invalid name! Name must be 1-20 characters long and contain only letters and numbers.");
        }
    }

    private char getUniquePlayerSymbol() {
        while (true) {
            char symbol = input.getCharInput("Enter player symbol: ");
            if (isValidPlayerSymbol(symbol)) {
                return symbol;
            }
            display.println("Invalid symbol! Symbol must be a single character and not already in use.");
        }
    }

    private boolean isValidPlayerName(String name) {
        return name != null &&
                name.length() > 0 &&
                name.length() <= 20 &&
                name.matches("[a-zA-Z0-9]+");
    }

    private boolean isValidPlayerSymbol(char symbol) {
        return symbol != ' ' &&
                symbol != '_' &&
                !usedSymbols.contains(symbol);
    }
}