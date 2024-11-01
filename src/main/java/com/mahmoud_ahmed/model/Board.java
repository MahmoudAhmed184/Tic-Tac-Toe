package com.mahmoud_ahmed.model;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {
    private final int size;
    private final char[] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size * size];
        Arrays.fill(grid, '_');
    }

    public int getSize() {
        return this.size;
    }

    public char[] getBoardState() {
        return Arrays.copyOf(this.grid, this.grid.length);
    }

    public boolean applyMove(int position, char symbol) {
        if (isPositionWithinBounds(position) && isPositionEmpty(position)) {
            grid[position - 1] = symbol;
            return true;
        }
        return false;
    }

    public boolean isPositionWithinBounds(int position) {
        return position > 0 && position <= grid.length;
    }

    public boolean isPositionEmpty(int position) {
        return grid[position - 1] == '_';
    }

    public boolean isFull() {
        return IntStream.range(0, grid.length)
                .allMatch(i -> grid[i] != '_');
    }

    public boolean isRowFilledWith(int row, char symbol) {
        return IntStream.range(0, size)
                .allMatch(i -> grid[row * size + i] == symbol);
    }

    public boolean isColumnFilledWith(int column, char symbol) {
        return IntStream.range(0, size)
                .allMatch(i -> grid[i * size + column] == symbol);
    }

    public boolean isMainDiagonalFilledWith(char symbol) {
        return IntStream.range(0, size)
                .allMatch(i -> grid[i * size + i] == symbol);
    }

    public boolean isAntiDiagonalFilledWith(char symbol) {
        return IntStream.range(0, size)
                .allMatch(i -> grid[i * size + size - i - 1] == symbol);
    }

    public void resetBoard() {
        Arrays.fill(grid, '_');
    }
}
