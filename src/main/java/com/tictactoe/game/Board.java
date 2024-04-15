package com.tictactoe.game;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {
    private final int size;
    private final char[] grid;
    private final String LINE_SEPARATOR;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size * size];
        Arrays.fill(grid, '_');
        this.LINE_SEPARATOR = "-".repeat(size * 4 + 1);
    }

    public void displayBoard() {
        clearConsoleScreen();
        System.out.println(LINE_SEPARATOR);
        for (int i = 0; i < grid.length; i++) {
            System.out.printf("| %c ", grid[i]);
            if ((i + 1) % size == 0) {
                System.out.println("|\n" + LINE_SEPARATOR);
            }
        }
    }

    private void clearConsoleScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean updateBoard(int position, char symbol) {
        if (isValidMove(position - 1)) {
            grid[position - 1] = symbol;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int index) {
        if (index < 0 || index >= grid.length) {
            return false;
        }
        return grid[index] == '_';
    }

    public void resetBoard() {
        Arrays.fill(grid, '_');
    }

    public boolean isMoveLeft() {
        return IntStream.range(0, grid.length)
                .anyMatch(i -> grid[i] == '_');
    }

    public boolean isWinningMove(char symbol) {
        return IntStream.range(0, size)
                .anyMatch(i -> checkRow(i, symbol) || checkColumn(i, symbol))
                || checkDiagonals(symbol);
    }

    private boolean checkRow(int row, char symbol) {
        return IntStream.range(0, size)
                .allMatch(i -> grid[row * size + i] == symbol);
    }

    private boolean checkColumn(int column, char symbol) {
        return IntStream.range(0, size)
                .allMatch(i -> grid[i * size + column] == symbol);
    }

    private boolean checkDiagonals(char symbol) {
        return IntStream.range(0, size)
                .allMatch(i -> grid[i * size + i] == symbol)
                || IntStream.range(0, size)
                        .allMatch(i -> grid[i * size + size - i - 1] == symbol);
    }
}
