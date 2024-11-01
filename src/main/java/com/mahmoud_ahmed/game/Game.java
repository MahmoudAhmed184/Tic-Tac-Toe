package com.mahmoud_ahmed.game;

import java.util.stream.IntStream;
import com.mahmoud_ahmed.model.*;
import com.mahmoud_ahmed.ui.*;

public class Game {
    private final Console console;
    private final Board board;
    private final PlayerTurnManager turnManager;
    private GameState currentState;

    public Game(int boardSize, int numberOfPlayers) {
        this.console = new Console();
        this.board = new Board(boardSize);
        this.turnManager = new PlayerTurnManager(numberOfPlayers);
        initializePlayers(numberOfPlayers);
        this.currentState = GameState.IN_PROGESS;
    }

    public void startGame() {
        while (currentState == GameState.IN_PROGESS) {
            processTurn();
            updateGameState();
        }
        handleGameOver();
    }

    private void initializePlayers(int numberOfPlayers) {
        IntStream.range(0, numberOfPlayers)
                .forEach(playerNumber -> turnManager.addPlayer(console.createPlayer(playerNumber)));
    }

    private void processTurn() {
        console.displayBoard(board);
        Player currentPlayer = turnManager.getCurrentPlayer();
        console.displayPlayerTurn(currentPlayer);
        int position = getValidPosition(board);
        board.applyMove(position, currentPlayer.getSymbol());
    }

    public int getValidPosition(Board board) {
        while (true) {
            int position = console.getMoveInput(board.getSize() * board.getSize());
            if (isValidPosition(board, position)) {
                return position;
            }
            console.displayInvalidMoveError();
        }
    }

    private boolean isValidPosition(Board board, int position) {
        return board.isPositionWithinBounds(position) && board.isPositionEmpty(position);
    }

    private void updateGameState() {
        currentState = evaluateGame(board, turnManager.getCurrentPlayer());

        if (currentState == GameState.IN_PROGESS) {
            turnManager.switchToNextPlayer();
        }
    }

    private GameState evaluateGame(Board board, Player player) {
        if (hasPlayerWon(player)) {
            return GameState.WIN;
        }
        if (board.isFull()) {
            return GameState.DRAW;
        }
        return GameState.IN_PROGESS;
    }

    public boolean hasPlayerWon(Player player) {
        char symbol = player.getSymbol();
        return IntStream.range(0, board.getSize())
                .anyMatch(
                        index -> board.isRowFilledWith(index, symbol)
                                || board.isColumnFilledWith(index, symbol))
                || board.isMainDiagonalFilledWith(symbol)
                || board.isAntiDiagonalFilledWith(symbol);
    }

    private void handleGameOver() {
        console.displayBoard(board);
        switch (currentState) {
            case WIN:
                console.displayWinner(turnManager.getCurrentPlayer());
                break;
            case DRAW:
                console.displayDraw();
                break;
            default:
                break;
        }
    }
}
