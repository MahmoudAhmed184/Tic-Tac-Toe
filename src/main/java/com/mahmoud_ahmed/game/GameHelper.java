package com.mahmoud_ahmed.game;

import com.mahmoud_ahmed.model.Board;
import com.mahmoud_ahmed.ui.Console;

public class GameHelper {
    
    private GameHelper() {}

    public static int getValidPosition(Console console, Board board) {
        while (true) {
            int position = console.getMoveInput(board.getSize() * board.getSize());
            if (isValidPosition(board, position)) {
                return position;
            }
            console.displayInvalidMoveError();
        }
    }

    private static boolean isValidPosition(Board board, int position) {
        return board.isPositionWithinBounds(position) && board.isPositionEmpty(position);
    }
}
