package com.mahmoud_ahmed.ui;

import com.mahmoud_ahmed.model.Board;

public class BoardFormatter {
    private BoardFormatter() {}

    public static String format(Board board) {
        int side = board.getSize();
        char[] grid = board.getBoardState();
        String separator = generateSeparator(side);

        StringBuilder result = new StringBuilder();
        result.append(separator).append('\n');

        for (int i = 0; i < grid.length; i++) {
            result.append(String.format("| %c ", grid[i]));
            if ((i + 1) % side == 0) {
                result.append("|\n").append(separator).append('\n');
            }
        }

        return result.toString();
    }

    private static String generateSeparator(int side) {
        return "-".repeat(side * 4 + 1);
    }
}