package com.mahmoud_ahmed.game;

import java.util.stream.IntStream;

import com.mahmoud_ahmed.model.Board;
import com.mahmoud_ahmed.model.GameState;
import com.mahmoud_ahmed.model.Player;

public class GameEvaluator {

    public GameEvaluator() {}

    public GameState evaluateGame(Board board, Player player) {
        if (hasPlayerWon(board, player)) {
            return GameState.WIN;
        }
        if (board.isFull()) {
            return GameState.DRAW;
        }
        return GameState.IN_PROGESS;
    }

    private boolean hasPlayerWon(Board board, Player player) {
        char symbol = player.getSymbol();
        return IntStream.range(0, board.getSize())
                .anyMatch(
                        index -> board.isRowFilledWith(index, symbol)
                                || board.isColumnFilledWith(index, symbol))
                || board.isMainDiagonalFilledWith(symbol)
                || board.isAntiDiagonalFilledWith(symbol);
    }
}
